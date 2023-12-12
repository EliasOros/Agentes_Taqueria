package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static Agentes.Cajero.aux;
import static Agentes.Cajero.efectivo_ingresado;
import static Agentes.Cajero.total;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class InterfazServidor extends JFrame implements ActionListener{
    public JPanel panel;
    public JTextArea area_texto;
    public JButton btnImprimir;
    public JScrollPane scroll;
    
    public InterfazServidor(){
        super("Pizzeria Italiana");
        this.setSize(500, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setContentPane(agregarPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private JPanel agregarPanel(){
        this.panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 600);
        
        area_texto = new JTextArea();
        
        scroll = new JScrollPane(area_texto);
        scroll.setBounds(10,10,465,500);
        
        btnImprimir = new JButton("Imprimir Comprobante");
        btnImprimir.setBounds(150, 520, 200, 30);
        btnImprimir.setActionCommand("imprimir");
        btnImprimir.addActionListener(this);
        
        panel.add(scroll);
        panel.add(btnImprimir);
        
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch(comando){
            case "imprimir":
                CrearPDF archivo = new CrearPDF(aux, efectivo_ingresado, total);
                archivo.escribir();
            break;
        }
    }
    
}
