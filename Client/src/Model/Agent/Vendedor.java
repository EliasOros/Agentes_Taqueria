package Model.Agent;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;

import Controller.ControladorCliente;
import View.InterfazCliente;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class Vendedor extends Agent{
    int i=0, j=0;
    public String orden_inicial = "";
    public String orden_final = "";
    public InterfazCliente vista;
    public ControladorCliente controller;
    
    class EmisorComportamiento extends SimpleBehaviour {
        boolean fin = false;
        
        @Override
        public void action() {
            AID id = new AID();
            id.setLocalName("Chef");

            
            ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
            mensaje.setSender(getAID());
            mensaje.setLanguage("spanish");
            mensaje.addReceiver(id);
            mensaje.setContent(orden_inicial);
            orden_final = orden_inicial;

            send(mensaje);
            if (i == 0) {
                System.out.println(getLocalName() + ": Pasando orden al Chef");
                System.out.println(orden_inicial);
            }


            ACLMessage mensaje2 = blockingReceive();
            if (mensaje2 != null) {
                System.out.println(getLocalName() + ": acaba de recibir la siguiente orden ");
                orden_inicial = mensaje2.toString();
                System.out.println(orden_final);
                JOptionPane.showMessageDialog(null, "Para proceder con su orden, favor de pagar la cuenta");
                fin = true;
            }
        }
        @Override
        public boolean done() {
            return fin;
        }
    }
    
    class esperaOrden extends SimpleBehaviour {
        boolean va=false  ;

        @Override
        public void action() {
            String mensaje = controller.pedido;
            if (mensaje != "") {
                if(j==0){
                    System.out.println(getLocalName() + ": Orden recibida");
                    System.out.println(getLocalName() + ": enviando orden al chef...");
                }
                j=1;
                va=true;    
            }else{
                System.out.println("Vendedor esperando cliente nuevo!!!");
                block();
                i++;
                orden_inicial = controller.pedido;
            }
        }

        @Override
        public boolean done() {
            if (va == true) {
                myAgent.addBehaviour(new EmisorComportamiento());
            } else {
                myAgent.addBehaviour(new esperaOrden());
            }
            return va;
        }
    }
    
    @Override
    protected void setup() {
        vista = new InterfazCliente();
        controller = new ControladorCliente(vista);
        controller.iniciar();
        addBehaviour(new esperaOrden());
    }
    
    
}
