package View;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class CrearTXT {
    private String[] articulos;
    private double total;
    private double efectivo;
    
    // Constructor que recibe un array de artículos, el efectivo y el total
    public CrearTXT(String[] articulos, double efectivo, double total){
        this.articulos = articulos;
        this.efectivo = efectivo;
        this.total = total;
    }
    
    // Método para escribir en el archivo de texto
    public void escribir(){
        // Se especifica la ubicación y nombre del archivo de texto
        File file = new File("C:/Users/lalit/Downloads/IAProyectoFinal/Pizzería/AI-Project-Server/Comprobante.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            // Se agrega un encabezado al archivo de texto
            writer.write("Pizzeria Italiana\n\n");
            
            // Se agregan los artículos al archivo de texto
            for(int i=0; i<articulos.length-2; i++){
                writer.write(articulos[i] + "\n");
            }
            
            // Se agrega un párrafo con el total, el efectivo y el cambio al archivo de texto
            writer.write("\nTotal: " + total + "\n" + "Efectivo: " + efectivo + "\nCambio: " + (efectivo-total));

            // Se imprime un mensaje en la consola indicando que el archivo de texto ha sido creado
            System.out.println("Archivo de texto creado");
            
        } catch (IOException ex) {
            // En caso de error de entrada/salida, se imprime el mensaje de error
            System.out.println(ex.getMessage());
        }
        
        // Se muestra un cuadro de diálogo indicando que el comprobante ha sido creado con éxito
        JOptionPane.showMessageDialog(null, "Comprobante creado con éxito");
    }   
}
