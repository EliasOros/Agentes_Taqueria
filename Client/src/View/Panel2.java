/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class Panel2 extends JPanel {

    private static final long serialVersionUID = 1L;
    public Image imagen;
    public URL fondo;

    public Panel2() {
            fondo = this.getClass().getResource("/Imagenes/pizzeria.jpg");
            imagen = new ImageIcon(fondo).getImage();
    }

    public void paintComponent(Graphics g) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
    }
}
