package Model.Agent;

import java.util.ArrayList;

import Model.Ontologia.Accion;
import Model.Ontologia.Comunicacion;
import Model.Ontologia.Ontologia;
import Model.Ontologia.Producto;
import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Taquero extends Agent {

	private Codec codec = new SLCodec();
	private Ontology ontologia = Ontologia.getInstance();
	private ArrayList<Producto> pedidos;
	private int tamano = 0;
	private int tamanoPedidos = 0;
	private int cantidad = 0;
	private ACLMessage msg;
	private Producto fru;

	class tamano extends SimpleBehaviour {
		private boolean finished = false;

		@Override
		public void action() {

			ACLMessage cal = blockingReceive();
			if (cal != null) {

				tamanoPedidos = Integer.parseInt(cal.toString());

				WaitPingAndReplyBehaviour PingBehaviour;
				PingBehaviour = new WaitPingAndReplyBehaviour(myAgent);
				addBehaviour(PingBehaviour);

				finished = true;
			}
		}

		@Override
		public boolean done() {
			// TODO Auto-generated method stub
			return finished;
		}

	}

	class WaitPingAndReplyBehaviour extends SimpleBehaviour {
		private boolean finished = false;

		public WaitPingAndReplyBehaviour(Agent a) {
			super(a);
		}

		@Override
		public void action() {
			
			System.out.println("\nEsperando orden....");

			MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),
					MessageTemplate.MatchOntology(ontologia.getName()));
			msg = blockingReceive(mt);

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
								fru = of.getProducto();
								System.out.println("Orden recibida:");
								System.out.println("Nombre: " + fru.getNombre());
								System.out.println("Cantidad: "+ fru.getCantidad());

								pedidos.add(fru);
								cantidad+=fru.getCantidad();
								tamano++;
								
								
								
								System.out.println("Preparando orden");
								System.out.println("Preparando " + fru.getCantidad()+" de: "+fru.getNombre());
								
								int tmpEsp = Integer.parseInt(fru.getCantidad()+"000");
								block(tmpEsp);
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
				
				try {
					ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
					msg2.setSender(getAID());
					msg2.setLanguage(codec.getName());
					msg2.setOntology(ontologia.getName());
					msg2.addReceiver(msg.getSender());

					for (Producto Ped : pedidos) {
						Comunicacion comu = new Comunicacion();
						comu.setProducto(Ped);
						
						getContentManager().fillContent(msg2, comu);
						send(msg2);

					}
				} catch (CodecException | OntologyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				

				System.out.println("Orden terminada");

				/*
				 * //Compramos Accion compra = new Accion(); compra.setProducto(fru); ACLMessage
				 * msg2 = new ACLMessage(ACLMessage.INFORM); msg2.setLanguage(codec.getName());
				 * msg2.setOntology(ontologia.getName()); msg2.setSender(getAID());
				 * msg2.addReceiver(msg.getSender());
				 * getContentManager().fillContent(msg2,compra); send(msg2);
				 * System.out.println("Termino este pedido");
				 * 
				 * 
				 * 
				 * AID r = new AID(); r.setLocalName("Taquero"); ACLMessage msg = new
				 * ACLMessage(ACLMessage.REQUEST); msg.setSender(getAID()); msg.addReceiver(r);
				 * msg.setLanguage(codec.getName()); msg.setOntology(ontologia.getName());
				 * 
				 * for(Producto pro : CC.getListaProducto){
				 * 
				 * Comunicacion comu = new Comunicacion(); comu.setProducto(pro);
				 * 
				 * getContentManager().fillContent(msg, comu);
				 * 
				 * send(msg);
				 * 
				 */

			}

			return finished;
		}
	}

	@Override
	protected void setup() {
		pedidos = new ArrayList<>();
		getContentManager().registerLanguage(codec);
		getContentManager().registerOntology(ontologia);

		addBehaviour(new tamano());

	}
}
