package Model.Agent;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class Chef extends Agent{
    
    ACLMessage aux;
    String orden = "";
    
    class ReceptorComportamiento extends SimpleBehaviour {
        
        public void onStart() {
            System.out.println("Chef listo para hornear pizzas....");
        }
        
        @Override
        public void action() {
            
            ACLMessage mensaje = blockingReceive();
            if (mensaje != null) {
                orden = mensaje.toString();              
                aux = mensaje;
                myAgent.addBehaviour(new horneandoPizza());
            } else {
                block();
            }
        }
        @Override
        public boolean done() {
            return true;
        }
    }
    
    private class horneandoPizza extends Behaviour {

        int numeroEjecuciones = 0;
        
        public void action() {
            
            if (numeroEjecuciones == 1) {
                System.out.println("La pizza entro en el horno, espere un momento!");
            }
            numeroEjecuciones++;
            block(5000);
            if (numeroEjecuciones == 5) {
                System.out.println(getLocalName() + ": La orden esta completa");
                System.out.println(getLocalName() + ": Enviando orden al Vendedor...");
            }
        }
        
        public boolean done() {
            if (numeroEjecuciones > 10) {
                myAgent.addBehaviour(new finalizarPedido());
                return true;
            } else {
                return false;
            }
        }   
    }
    
    private class finalizarPedido extends Behaviour {
        public void action() {
            if (aux != null) {
                ACLMessage respuesta1 = new ACLMessage(ACLMessage.INFORM);
                respuesta1.setContent(orden);
                respuesta1.addReceiver(aux.getSender());
                send(respuesta1);
                System.out.println(respuesta1.toString());
            } else {
                System.out.println("ERROR: ");
            }
        }

        public boolean done() {
            return true;
        }
    }
    
    @Override
    protected void setup() {
        addBehaviour(new ReceptorComportamiento());

    }

    protected void takeDown() {
        System.out.println("El Chef ha terminado de hornear");
    }
    
    private void getOrden() {
        int tama = 0, i = 0;
        char comillas = '"';
        tama = orden.length();
        String orden_actual = "";
        do {
            if (orden.charAt(i) == comillas) {
                i++;
                while (orden.charAt(i) != comillas) {
                    orden_actual = orden_actual + orden.charAt(i);
                    i++;
                }
            }
            i++;
        } while (i < tama);
        orden = orden_actual;
    }
    
}
