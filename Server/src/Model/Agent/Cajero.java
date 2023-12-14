package Model.Agent;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import Model.Ontologia.Comunicacion;
import Model.Ontologia.Ontologia;
import Model.Ontologia.Producto;
import Controller.ControladorServidor;
import Model.Objetos.Prod;

import View.CrearTXT;

import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.lang.acl.MessageTemplate;

import java.text.DecimalFormat;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
 */
public class Cajero extends Agent {

    private Codec codec = new SLCodec();
    private Ontology ontologia = Ontologia.getInstance();
    private double total = 0;
    private int tamano = 0;
    private int tamanoPedidos = 0;
    private ControladorServidor cS;
    private ArrayList<Prod> productos;

    /*
	public static String pedido = "";
	InterfazServidor vista;
	public String pedido_inicial = "";
	public static double efectivo_ingresado = 0;
	public static double total = 0;
	public static String[] aux;
	private Prod pro;
	private ArrayList<Prod> listaProductos;
	
	DecimalFormat formato = new DecimalFormat("#.00");

	int k = 0, j = 0;
     */
    class tamano extends SimpleBehaviour {

        private boolean finished = false;

        /*
        @Override
        public void onStart() {
            MessageTemplate filtroInform = MessageTemplate.MatchPerformative(ACLMessage.INFORM_REF);
            ACLMessage cal = blockingReceive(filtroInform);
            try {
                // Extraer la ontología del mensaje
                ontologia = (Ontologia) cal.getContentObject();
                getContentManager().registerLanguage(codec);
                getContentManager().registerOntology(ontologia);
                
            } catch (UnreadableException e) {
                e.printStackTrace();
            }
        }
         */
        @Override
        public void action() {
            System.out.println("\nEsperando orden....");
            ACLMessage cal = blockingReceive();

            if (cal != null) {

                tamanoPedidos = Integer.parseInt(cal.toString());

                finished = true;
            }
        }

        @Override
        public boolean done() {

            return finished;
        }

    }

    class ObtenerOrden extends SimpleBehaviour {

        private boolean finished = false;

        public void suma(double precio, int cantidad) {
            total += precio * cantidad;
        }

        @Override
        public void action() {

            System.out.println("\nEsperando orden....");
            MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),
                    MessageTemplate.MatchOntology(ontologia.getName()));
            ACLMessage msg = blockingReceive(mt);

            try {

                if (msg != null) {
                    if (msg.getPerformative() == ACLMessage.NOT_UNDERSTOOD) {
                        System.out.println("Mensaje NOT UNDERSTOOD recibido");
                    } else {
                        if (msg.getPerformative() == ACLMessage.REQUEST) {

                            ContentElement ec = getContentManager().extractContent(msg);
                            if (ec instanceof Comunicacion) {
                                // Recibido un INFORM con contenido correcto
                                Comunicacion of = (Comunicacion) ec;
                                Producto fru = of.getProducto();

                                System.out.println("Orden recibida:");
                                System.out.println("Nombre: " + fru.getNombre());
                                System.out.println("Precio: " + fru.getPrecio());
                                System.out.println("Cantidad: " + fru.getCantidad());

                                suma(fru.getPrecio(), fru.getCantidad());
                                productos.add(new Prod(fru.getNombre(), String.valueOf(fru.getPrecio()), fru.getCantidad()));
                                tamano++;
                                /*
								for (int i = 0; i <= cantidad; i++) {
									System.out.println("Preparando " + fru.getCantidad()+" de: "+fru.getNombre());
									block();
								}
                                 */
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
            if (tamano < tamanoPedidos) {

                finished = true;
            } else {
                addBehaviour(new resultado());
                /*
                AID r = new AID();
                    r.setName("Mesero");
                    r.addAddresses("");//Direccion ip y puerto

                    ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
                    msg2.setSender(getAID());
                    msg2.setLanguage(codec.getName());
                    msg2.setOntology(ontologia.getName());
                    msg2.setContent(""+total);
                    msg2.addReceiver(r);
                 */
                System.out.println("Orden terminada");
            }

            return finished;
        }

    }

    class resultado extends SimpleBehaviour {

        private boolean finished = false;
        private boolean var = false;

        @Override
        public void action() {
            if (var == false) {
                cS = new ControladorServidor(total, productos);
                var = true;
            } else {

            }

            //cS.ListaProductos(productos);
        }

        @Override
        public boolean done() {
            if (cS.isOccurrio() == true) {

                System.out.println("Termino, estees el cambio: " + cS.getCambio());
                AID r = new AID();
                r.setName("Mesero");
                r.addAddresses("");//Direccion ip y puerto

                ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
                msg2.setSender(getAID());
                msg2.setLanguage(codec.getName());
                msg2.setOntology(ontologia.getName());
                msg2.setContent("" + cS.getCambio());
                msg2.addReceiver(r);

                finished = true;
            }
            return finished;
        }

    }

    /*
	class esperaOrden extends SimpleBehaviour {
		boolean va = false;

		@Override
		public void action() {
			String mensaje = CC.toString();
			if () {
				va = true;
			} else {
				vista.area_texto.setText("El cajero esta esperando un nuevo pedido...");
				j++;
				pedido_inicial = pedido;
				if (pedido_inicial != "") {
					obtenerCT();
				}
				block();
			}
		}

		@Override
		public boolean done() {
			if (va == true) {
				myAgent.addBehaviour(new ComportamientoSuma());
			} else {
				myAgent.addBehaviour(new esperaOrden());
			}
			return va;
		}
	
	
	public void obtenerCT() {
		aux = pedido_inicial.split(",");
		int n_elementos = aux.length;
		JOptionPane.showMessageDialog(null, "Se recibio una orden de pago\n\n");
		efectivo_ingresado = Double.parseDouble(aux[n_elementos - 2]);
		total = Double.parseDouble(aux[n_elementos - 1]);
	}

	public double Cambio() {
		double cambio = 0;
		cambio = efectivo_ingresado - total;
		return cambio;
	}

	private class ComportamientoSuma extends Behaviour {
		boolean v = false;
		int i = 0;

		public void action() {
			if (i == 0) {
				vista.area_texto.append("\n\nRevisando la orden");

			}
			if (i == 10) {
				vista.area_texto.append("\n\nLa orden a pagar es de: " + total);
				vista.area_texto.append("\nEl cliente pago con:" + efectivo_ingresado);
				vista.area_texto.append("\nEl cambio es de: " + formato.format(Cambio()));
				vista.area_texto.append("\n\nGracias por su preferencia");
			} else {
				block(2000);
			}
			i++;
		}

		@Override
		public boolean done() {
			if (i > 10) {
				myAgent.doDelete();
				v = true;
			}

			return v;
		}
	}
	/*
	class esperaOrden extends SimpleBehaviour {
		boolean va = false;

		@Override
		public void action() {
			String mensaje = pedido_inicial;
			if (mensaje != "") {
				va = true;
			} else {
				vista.area_texto.setText("El cajero esta esperando un nuevo pedido...");
				j++;
				pedido_inicial = pedido;
				if (pedido_inicial != "") {
					obtenerCT();
				}
				block();
			}
		}

		@Override
		public boolean done() {
			if (va == true) {
				myAgent.addBehaviour(new ComportamientoSuma());
			} else {
				myAgent.addBehaviour(new esperaOrden());
			}
			return va;
		}
	}
     */
    @Override
    protected void setup() {
        productos = new ArrayList<>();
        

        addBehaviour(new resultado());
    }
}
