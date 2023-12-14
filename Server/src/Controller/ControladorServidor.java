
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Agent.Cajero;
import Model.Objetos.Prod;

import View.Cobro;
import View.TicketView;
import java.util.ArrayList;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class ControladorServidor implements ActionListener{
    private double total = 0;
    private ControladorServidor cS;
    private double cambio;
    private boolean occurrio = false;
    private Cobro cobro;
    private ArrayList<Prod> productos;
    
    public ControladorServidor(double total,ArrayList<Prod> productos){
        this.total = total;
        cobro = new Cobro();
        cobro.setcS(this);
        System.out.println("Estos son buenos: "+productos);
        
        cobro.setProductos(productos);
        
        cobro.SetDinero(total);
        cobro.setVisible(true);
        
    }
    
    public ControladorServidor(){
        
        
    }

    public boolean isOccurrio() {
        return occurrio;
    }

    public void setOccurrio(boolean occurrio) {
        this.occurrio = occurrio;
    }
    
    public ControladorServidor getcS() {
        return cS;
    }

    public void setcS(ControladorServidor cS) {
        this.cS = cS;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public ArrayList<Prod> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Prod> productos) {
        this.productos = productos;
    }
    
    
    
    
    public void ListaProductos(ArrayList<Prod> productos,double dinero) {
        String ticket = "Tacos y mas Allá\n\n";
        ticket += "Producto\tCantidad\tPrecio u\ttotal\n";
        
        for (Prod pro : productos) {
            ticket+=pro.getNombre()+"\t"+pro.getCantidad()+"\t"+pro.getPrecio()+"\t"+
                    (Double.parseDouble(pro.getPrecio())*pro.getCantidad())+"\n";
        }
        cambio=dinero-total;
        this.setCambio(cambio);
        ticket+="\t\t\t\t\ttotal: "+total+"\n";
        ticket+="\t\t\t\t\tcambio: "+cambio;
        occurrio = true;
        
        TicketView tikcet = new TicketView(ticket);
        
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }    
}
