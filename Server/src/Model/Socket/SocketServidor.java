/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Model.Agent.Cajero;
import View.InterfazServidor;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class SocketServidor extends Thread{
    private InterfazServidor vista;
    
    public SocketServidor(InterfazServidor vista){
        this.vista = vista;
    }
    

    @Override
    public void run() {
        try{
            ServerSocket servidor = new ServerSocket(5000);
            
            while(true){
                Socket socket = servidor.accept();
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                String mensaje = entrada.readUTF();
                Cajero.pedido = mensaje;
                vista.area_texto.append("\n\nOrden recibida del vendedor: \n" + Cajero.pedido);
                servidor.close();
            }

      }catch(IOException e){
          
      }
    }
    
}