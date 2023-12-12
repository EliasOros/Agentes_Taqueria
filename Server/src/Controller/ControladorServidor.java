
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Agent.Cajero;
import Model.Socket.SocketServidor;
import View.InterfazServidor;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class ControladorServidor implements ActionListener{
    protected InterfazServidor vista;
    protected Cajero cajero;
    
    public ControladorServidor(InterfazServidor vista, Cajero cajero){
        this.vista = vista;
        this.cajero = cajero;
    }
    
    public void iniciar() {
        vista.setVisible(true);
        this.vista.btnImprimir.setActionCommand("Imprimir");
        this.vista.btnImprimir.addActionListener(this);        
    }
    
    public static void main(String[] args) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }    
}
