package Model.Agent;

import View.Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Controller.ControladorCliente;
import Model.Ontologia.Accion;
import Model.Ontologia.Comunicacion;
import Model.Ontologia.Ontologia;
import Model.Ontologia.Producto;
import Model.Vender.Prod;
import View.InterfazCli;
import View.Orden;
import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import javax.swing.JOptionPane;

public class Mesero extends Agent implements ActionListener {

    private Codec codec = new SLCodec();
    private Ontology ontologia = Ontologia.getInstance();
    private ControladorCliente CC;
    private boolean Orden = false;

    private ArrayList<Prod> listaProductos;
    private ArrayList<Producto> listaOrden;
    private int tamano = 0;
    private Producto fru;
    private ACLMessage msg;

    @Override
    protected void setup() {
        /**
         * Registrarse en el DF
         */

        listaProductos = new ArrayList<>();
        /*
        CC = new ControladorCliente();
        CC.setPedido(listaProductos);
        p.setCc(CC);
         */

        CC = new ControladorCliente("Iniciar");
        //CC.setPedido(listaProductos);
        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Mesero");
        sd.setName(getName());

        dfd.setName(getAID());
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            System.err.println(getLocalName() + " registration with DF unsucceeded. Reason: " + e.getMessage());
            doDelete();
        }

        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontologia);
        /*
        RecibirPedido resPed = new RecibirPedido(this); 
        addBehaviour(resPed);
         */

        esperaOrden esperaOrden = new esperaOrden(this);
        addBehaviour(new esperaOrden(this));

    }

    class RecibirPedido extends SimpleBehaviour {

        private boolean finished = false;

        @Override
        public void action() {

            listaOrden = new ArrayList<>();
            System.out.println("Llevando orden");
            for (Prod pro : listaProductos) {
                System.out.println(pro.getNombre());
                System.out.println(pro.getPrecio());
                System.out.println(pro.getCantidad());
                listaOrden.add(new Producto(pro.getNombre(), Double.parseDouble(pro.getPrecio()), pro.getCantidad()));

            }
//**********************************************************************************************
            AID r = new AID();
            r.setName("Taquero");
            r.addAddresses("");//Direccion ip y puerto
/*
            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM_REF);

            try {
                mensaje.setContentObject(ontologia);
            } catch (IOException e) {
                e.printStackTrace();
            }


            mensaje.addReceiver(r);
            send(mensaje);
             */
//**********************************************************************************************
            listaProductos = CC.getCc().getPedido();

            for (Prod Prod : listaProductos) {

                listaOrden.add(new Producto(Prod.getNombre(), Double.parseDouble(Prod.getPrecio()), Prod.getCantidad()));
            }

//**********************************************************************************************
            try {
                System.out.println("Empesando");

                msg = new ACLMessage(ACLMessage.REQUEST);
                msg.setSender(getAID());
                msg.addReceiver(r);
                msg.setLanguage(codec.getName());
                msg.setOntology(ontologia.getName());

                for (Producto pro : listaOrden) {
                    //System.out.println("Nombre: "+pro.getNombre()+", Precio: "+pro.getPrecio()+", Cantidad: "+pro.getCantidad() );

                    Comunicacion comu = new Comunicacion();
                    comu.setProducto(pro);

                    getContentManager().fillContent(msg, comu);

                    send(msg);
                    System.out.println("La orden fue entregada al taquero");

                }

                finished = true;

            } catch (Exception e) {

            }

        }

        @Override
        public boolean done() {
            addBehaviour(new recibirOrden());
            return finished;
        }

    }

    class esperaOrden extends SimpleBehaviour {

        boolean va  = false;

        public esperaOrden(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            CC.obtenerPedido();
            if (CC.getCc() != null) {
                if (CC.getCc().getPedido() != null) {

                    String mensaje = CC.getCc().getPedido().toString();

                    if (Orden == false) {

                        System.out.println(getLocalName() + ": Orden recibida");
                        System.out.println(getLocalName() + ": enviando orden al taquero...");

                        AID r = new AID();
                        r.setName("Taquero");
                        r.addAddresses("");//Direccion ip y puerto

                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);

                        msg.setSender(getAID());
                        msg.addReceiver(r);
                        msg.setContent("" + CC.getCc().getPedido().size());// listaProductos.size()

                    }
                    Orden = true;
                    va  = true;
                } else {
                    //System.out.println("Mesero esperando cliente nuevo!!!");
                    block(8000);
                }

            } else {
                block(8000);
            }
            //System.out.println(CC.getCc().getPedido());

        }

        @Override
        public boolean done() {
            if (va  == true) {
                System.out.println("LLevando la orden...");
                block(3000);
                addBehaviour(new RecibirPedido());
            } else {
                //System.out.println("Regresamos");
                myAgent.addBehaviour(new esperaOrden(myAgent));
            }
            return va;

        }
    }

    class recibirOrden extends SimpleBehaviour {

        private boolean finished = false;

        @Override
        public void action() {

            MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),
                    MessageTemplate.MatchOntology(ontologia.getName()));
            msg = blockingReceive(mt);

            AID r = new AID();
            r.setLocalName("Cajero");
            r.addAddresses("");//Direccion ip y puerto

            ACLMessage msg3 = new ACLMessage(ACLMessage.INFORM);
            msg3.setLanguage(codec.getName());
            msg3.setOntology(ontologia.getName());
            msg3.setSender(getAID());
            msg3.setContent("" + CC.getCc().getPedido().size());
            msg3.addReceiver(r);

            send(msg3);
            /*
            AID r = new AID();
            r.setLocalName("Mesero");
            r.addAddresses("");//Direccion ip y puerto

            ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
            msg2.setSender(getAID());
            msg2.setLanguage(codec.getName());
            msg2.setOntology(ontologia.getName());
            msg2.addReceiver(r);

            for (Producto Ped : pedidos) {
                Comunicacion comu = new Comunicacion();
                comu.setProducto(Ped);

                getContentManager().fillContent(msg2, comu);
                send(msg2);

            }
             */
            try {

                if (msg != null) {
                    if (msg.getPerformative() == ACLMessage.NOT_UNDERSTOOD) {
                        System.out.println("Mensaje NOT UNDERSTOOD recibido");

                    } else {
                        if (msg.getPerformative() == ACLMessage.INFORM) {

                            ContentElement ec = getContentManager().extractContent(msg);
                            if (ec instanceof Comunicacion) {
                                // Recibido un INFORM con contenido correcto
                                Comunicacion of = (Comunicacion) ec;
                                fru = of.getProducto();

                                Comunicacion comu = new Comunicacion();
                                comu.setProducto(fru);

                                ACLMessage msg2 = new ACLMessage(ACLMessage.REQUEST);
                                msg2.setLanguage(codec.getName());
                                msg2.setOntology(ontologia.getName());
                                msg2.setSender(getAID());
                                msg2.addReceiver(r);

                                getContentManager().fillContent(msg2, comu);
                                tamano++;
                                send(msg2);

                            } else {
                                // Recibido un INFORM con contenido incorrecto
                                ACLMessage reply = msg.createReply();
                                reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                                reply.setContent("( UnexpectedContent (expected ping))");
                                send(reply);
                            }
                        } else {
                            // Recibida una performativa incorrecta
                            ACLMessage reply = msg.createReply();
                            reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                            reply.setContent("( (Unexpected-act " + ACLMessage.getPerformative(msg.getPerformative())
                                    + ")( expected (inform)))");
                            send(reply);
                        }
                    }
                } else {
                    // System.out.println("No message received");
                }

            } catch (jade.content.lang.Codec.CodecException ce) {
                System.out.println(ce);

            } catch (jade.content.onto.OntologyException oe) {
                System.out.println(oe);
            }

        }

        @Override
        public boolean done() {
            if (tamano < listaProductos.size()) {

                finished = true;
            } else {
                /*
                AID r = new AID();
                r.setName("Cajero");
                r.addAddresses("");

                msg = new ACLMessage(ACLMessage.REQUEST);
                msg.setSender(getAID());
                msg.addReceiver(r);
                msg.setLanguage(codec.getName());
                msg.setOntology(ontologia.getName());
                */
                
                
                
                
                
                MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),
                        MessageTemplate.MatchOntology(ontologia.getName()));
                msg = blockingReceive(mt);
                
                
                JOptionPane.showMessageDialog(null, "Este es su cambio: "+msg.getContent());
                

                System.out.println("Termino este pedido");
                /*
                Ya no se que hacer aqui, msg deberia obtener el el total, pero ya no se si ejecutar
                el controlador 
                
                
                
                
                
                
                
                
                
                try {
                    
                    
                    System.out.println("La orden fue entregada al taquero");
                    
                    
                    // Compramos
                    Accion compra = new Accion();
                    compra.setProducto(fru);

                    AID r = new AID();
                    r.setLocalName("Cajero");

                    ACLMessage msg2 = new ACLMessage(ACLMessage.REQUEST);
                    msg2.setLanguage(codec.getName());
                    msg2.setOntology(ontologia.getName());
                    msg2.setSender(getAID());
                    msg2.addReceiver(r);

                    getContentManager().fillContent(msg2, compra);
                    send(msg2);
                    finished = true;

                    
					 * Aqui debe de haber un comando para llamar al controlador y lanzar en vista lo
					 * que se pidio y si se quiere seguir pidiendo
                     
                    
                } catch (CodecException | OntologyException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                 */
            }
            return finished;

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
