package Interfaz;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.styledxmlparser.jsoup.nodes.Element;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class CrearPDF {
    private String[] articulos;
    private double total;
    private double efectivo;
    
    public CrearPDF(String[] articulos, double efectivo, double total){
        this.articulos = articulos;
        this.efectivo = efectivo;
        this.total = total;
    }
    
    public void escribir(){
        File file = new File("C:/Users/lalit/Downloads/IAProyectoFinal/Pizzería/AI-Project-Server/Comprobante.pdf");
        try (PdfWriter pdfWriter = new PdfWriter(file)) {

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            

            Paragraph p = new Paragraph("Pizzeria Italiana\n\n");
            
            document.add(p);
            
            for(int i=0; i<articulos.length-2; i++){
                Paragraph articulo = new Paragraph(articulos[i]);
                document.add(articulo);
            }
            
            Paragraph parrafo_final = new Paragraph("\n\nTotal: " + total + "\n" + "Efectivo: " + efectivo + "\nCambio: " + (efectivo-total));
            document.add(parrafo_final);
            

            document.close();
            pdfDocument.close();
            
            System.out.println("PDF creado");
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Comprobante creado con exito");
    }
    
}