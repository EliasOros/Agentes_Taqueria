package Model.Agent;

import View.Principal;

import java.util.ArrayList;

import Controller.ControladorCliente;
import Model.Ontologia.Accion;
import Model.Ontologia.Comunicacion;
import Model.Ontologia.Ontologia;
import Model.Ontologia.Producto;
import View.InterfazCli;
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


public class Mesero extends Agent {
	private Codec codec = new SLCodec();
    private Ontology ontologia = Ontologia.getInstance();
    private ControladorCliente CC;
    private boolean Orden = false;
    private ArrayList<Producto> listaProductos;
    private int tamano= 0;
    private Producto fru;
    
    private ACLMessage msg;
    class RecibirPedido extends SimpleBehaviour {
    	private boolean finished = false;
    	

		@Override
		public void action() {
			try {
				/*
				listaProductos = CC.listaProductos;
	            AID r = new AID();
				r.setLocalName("Taquero");
				msg = new ACLMessage(ACLMessage.REQUEST);
				msg.setSender(getAID());
				msg.addReceiver(r);
				msg.setLanguage(codec.getName());
				msg.setOntology(ontologia.getName());
					
				for(Producto pro : listaProducto){
	                
	            	Comunicacion comu = new Comunicacion();
	           		comu.setProducto(pro);
	 
	            	getContentManager().fillContent(msg, comu);
	 
	            	send(msg);
	            }
	            
	            finished = true;
	             * */
	            
	           
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
        boolean va=false  ;
        
        public esperaOrden (Agent a) {
        	super(a);
        }
        
        @Override
        public void action() {
            String mensaje = CC.toString();
            if (mensaje != "") {
                if(Orden == false){
                	//listaProductos = CC.listaProductos;
                    System.out.println(getLocalName() + ": Orden recibida");
                    System.out.println(getLocalName() + ": enviando orden al taquero...");
                    
                    AID r = new AID();
    				r.setLocalName("Taquero");
                    
                    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                    msg.setSender(getAID());
    				msg.addReceiver(r);
    				msg.setContent(""/*listaProductos.size()*/);
                }
                Orden = true;
                va=true;    
            }else{
                System.out.println("Mesero esperando cliente nuevo!!!");
                block();

            }
        }

        @Override
        public boolean done() {
            if (va == true) {
                myAgent.addBehaviour(new RecibirPedido());
            }
            return va;
        }
    }
    class recibirOrden extends SimpleBehaviour {
    	private boolean finished = false;
		@Override
		public void action() {
			
			MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),MessageTemplate.MatchOntology(ontologia.getName()));
			msg = blockingReceive(mt);
	 
	    	try {
	 
	    		if(msg != null){
	    			if(msg.getPerformative() == ACLMessage.NOT_UNDERSTOOD){
	    				System.out.println("Mensaje NOT UNDERSTOOD recibido");
	    				
	    			}else{
	    				if(msg.getPerformative()== ACLMessage.INFORM){
	
	    					ContentElement ec = getContentManager().extractContent(msg);
	    					if (ec instanceof Comunicacion){
	    						// Recibido un INFORM con contenido correcto
	    						Comunicacion of = (Comunicacion) ec;
	    						fru = of.getProducto();
	    						
	    						tamano++;
	    						
	    						
	    						
	    						System.out.println("Termino este pedido");
	    						  
	    						  
	    						 
	    					  }else{
	    						  // Recibido un INFORM con contenido incorrecto
	    						  ACLMessage reply = msg.createReply();
	    						  reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
	    						  reply.setContent("( UnexpectedContent (expected ping))");
	    						  send(reply);
	    					  }
	    				  }else {
	    					  // Recibida una performativa incorrecta
	    					  ACLMessage reply = msg.createReply();
	    					  reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
	    					  reply.setContent("( (Unexpected-act "+ACLMessage.getPerformative(msg.getPerformative())+")( expected (inform)))");
	    					  send(reply);
	    				  }
	    			  }
	    		  }else{
	    			  //System.out.println("No message received");
	    		  }
	    		  
	    	  }catch (jade.content.lang.Codec.CodecException ce) {
	               System.out.println(ce);
	              
	    	  }catch (jade.content.onto.OntologyException oe) {
	    		  System.out.println(oe);
	    	  }
			
		}

		@Override
		public boolean done() {
			if (tamano < listaProductos.size()) {
				
				
				finished = true;
			} else {
				
				try {
					
					//Compramos
					Accion compra = new Accion();
					compra.setProducto(fru);
					
					AID r = new AID();
    				r.setLocalName("Cajero");
    				
					ACLMessage msg2 = new ACLMessage(ACLMessage.REQUEST);
					msg2.setLanguage(codec.getName());
					msg2.setOntology(ontologia.getName());
					msg2.setSender(getAID());
					msg2.addReceiver(r);
				
					getContentManager().fillContent(msg2,compra);
					send(msg2);
					finished = true;
					
					/*
					 * Aqui debe de haber un comando para llamar al controlador y lanzar en vista lo que se pidio
					 * y si se quiere seguir pidiendo 
					 * */
					
				} catch (CodecException | OntologyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return finished;
    	
	}
 
    	
    	
    }
    @Override
    protected void setup() {
    	/** Registrarse en el DF */
    	
    	Principal Pri = new Principal();
    	//CC = new ControladorCliente();
    	
        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Mesero");
        sd.setName(getName());
        
        dfd.setName(getAID());
        dfd.addServices(sd);
        try {
        DFService.register(this,dfd);
        } catch (FIPAException e) {
            System.err.println(getLocalName()+" registration with DF unsucceeded. Reason: "+e.getMessage());
            doDelete();
        }
     
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontologia);
     
        esperaOrden esperaOrden = new esperaOrden(this);
        addBehaviour(new esperaOrden(this));
    }
    
}
