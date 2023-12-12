package Model.Agent;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import Model.Socket.SocketServidor;
import View.CrearTXT;
import View.InterfazServidor;

import java.text.DecimalFormat;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class Cajero extends Agent{
    public static String pedido = "";
    InterfazServidor vista;
    public String pedido_inicial = "";
    public static double efectivo_ingresado = 0;
    public static double total = 0;
    public static String[] aux;
    DecimalFormat formato = new DecimalFormat("#.00");
    
    SocketServidor socket_servidor;
    int k=0,j=0;
    
    public void obtenerCT(){
        aux = pedido_inicial.split(",");
        int n_elementos = aux.length;
        JOptionPane.showMessageDialog(null,"Se recibio una orden de pago\n\n");
        efectivo_ingresado = Double.parseDouble(aux[n_elementos-2]);
        total = Double.parseDouble(aux[n_elementos-1]);
    }    
    public double Cambio(){
        double cambio = 0;
        cambio = efectivo_ingresado - total;
        return cambio;
    }
   
    
    private class ComportamientoSuma extends Behaviour{
       boolean v=false; int i=0;
        
        public void action(){
            if(i==0){
              vista.area_texto.append("\n\nRevisando la orden");
              
            }
            if(i==10){    
                vista.area_texto.append("\n\nLa orden a pagar es de: " + total);
                vista.area_texto.append("\nEl cliente pago con:" + efectivo_ingresado);
                vista.area_texto.append("\nEl cambio es de: " + formato.format(Cambio()));
                vista.area_texto.append("\n\nGracias por su preferencia");
            }else{
            block(2000);     
            }
            i++;
        }
 
        
        @Override
        public boolean done(){
            if(i>10){
           myAgent.doDelete();   
           v=true;
            }
          
                return v;
        }
    } 
     class esperaOrden extends SimpleBehaviour {
       boolean va=false;  
        @Override
        public void action() {
            String mensaje =  pedido_inicial;     
            if (mensaje !=""){
               va=true;
            }else{   
                vista.area_texto.setText("El cajero esta esperando un nuevo pedido...");
                j++;
                pedido_inicial = pedido;
                if(pedido_inicial != ""){
                    obtenerCT();    
                }
                block(); 
            }
        }

        @Override
        public boolean done() {
            if(va==true){
                myAgent.addBehaviour(new ComportamientoSuma());
            }else{
                myAgent.addBehaviour(new esperaOrden());
            }
            return va;
        }
    }

    @Override
    protected void setup() {
        vista = new InterfazServidor();
        vista.setVisible(true);
        socket_servidor = new SocketServidor(vista); 
        socket_servidor.start();
        addBehaviour(new esperaOrden());
    }
}
