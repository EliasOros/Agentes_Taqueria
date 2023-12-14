package View;

import Controller.ControladorServidor;
import Model.Objetos.Prod;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class Cobro extends JFrame implements ActionListener {
    
    private ControladorServidor cS;
    private ArrayList<Prod> productos;
    public ControladorServidor getcS() {
        return cS;
    }

    public void setcS(ControladorServidor cS) {
        this.cS = cS;
    }

    public ArrayList<Prod> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Prod> productos) {
        this.productos = productos;
    }
    
    
    private JButton btnBillete200 = new JButton("");
    private JButton btnBillete100 = new JButton("");
    private JButton btnBillete50 = new JButton("");
    private JButton btnBillete20 = new JButton("");
    private JButton btnMoneda10 = new JButton("");
    private JButton btnMoneda5 = new JButton("");
    private JButton btnMoneda2 = new JButton("");
    private JButton btnMoneda1 = new JButton("");
    private JButton btnMoneda50Centavos = new JButton("");
    private final JButton btnNewButton = new JButton("Pagar");
    private final JLabel lblDineroIngresado = new JLabel("$0.00");
    private final JLabel lblDineroAPagar = new JLabel("Dinero a pagar");
    private final JLabel lblDineroaPagar = new JLabel("$0.00");

    public Cobro() {

        getContentPane().setBackground(new Color(255, 102, 51));
        getContentPane().setLayout(null);

        btnBillete200.setName("200");
        ImageIcon icon200 = new ImageIcon(Cobro.class.getResource("/Resources/Images/Billete de 200 pesos.png"));
        Image scaledImage200 = icon200.getImage().getScaledInstance(157, 69, Image.SCALE_SMOOTH);
        btnBillete200.setIcon(new ImageIcon(scaledImage200));
        btnBillete200.setBounds(220, 23, 157, 69);
        btnBillete200.addActionListener(this);
        getContentPane().add(btnBillete200);

        btnBillete100.setName("100");
        ImageIcon icon100 = new ImageIcon(Cobro.class.getResource("/Resources/Images/Billete de 100 pesos.png"));
        Image scaledImage100 = icon100.getImage().getScaledInstance(157, 69, Image.SCALE_SMOOTH);
        btnBillete100.setIcon(new ImageIcon(scaledImage100));
        btnBillete100.setBounds(220, 126, 157, 69);
        btnBillete100.addActionListener(this);
        getContentPane().add(btnBillete100);

        btnBillete50.setName("50");
        ImageIcon icon50 = new ImageIcon(Cobro.class.getResource("/Resources/Images/Billete de 50 pesos.png"));
        Image scaledImage50 = icon50.getImage().getScaledInstance(157, 69, Image.SCALE_SMOOTH);
        btnBillete50.setIcon(new ImageIcon(scaledImage50));
        btnBillete50.setBounds(220, 222, 157, 69);
        btnBillete50.addActionListener(this);
        getContentPane().add(btnBillete50);

        btnBillete20.setName("20");
        ImageIcon icon20 = new ImageIcon(Cobro.class.getResource("/Resources/Images/billete-20.jpg"));
        Image scaledImage20 = icon20.getImage().getScaledInstance(157, 69, Image.SCALE_SMOOTH);
        btnBillete20.setIcon(new ImageIcon(scaledImage20));
        btnBillete20.setBounds(220, 317, 157, 69);
        getContentPane().add(btnBillete20);
        btnBillete20.addActionListener(this);
        btnMoneda10.setFocusPainted(false);

        btnMoneda10.setName("10");
        btnMoneda10.setContentAreaFilled(false);
        ImageIcon icon10 = new ImageIcon(Cobro.class.getResource("/Resources/Images/Moneda de 10 pesos.png"));
        Image scaledImage10 = icon10.getImage().getScaledInstance(99, 47, Image.SCALE_SMOOTH);
        btnMoneda10.setIcon(new ImageIcon(scaledImage10));
        btnMoneda10.setBounds(407, 11, 99, 47);
        getContentPane().add(btnMoneda10);
        btnMoneda10.addActionListener(this);
        btnMoneda5.setFocusPainted(false);

        btnMoneda5.setName("5");
        btnMoneda5.setContentAreaFilled(false);
        ImageIcon icon5 = new ImageIcon(Cobro.class.getResource("/Resources/Images/Moneda 5 pesos.png"));
        Image scaledImage5 = icon5.getImage().getScaledInstance(99, 58, Image.SCALE_SMOOTH);
        btnMoneda5.setIcon(new ImageIcon(scaledImage5));
        btnMoneda5.setBounds(407, 75, 99, 58);
        getContentPane().add(btnMoneda5);
        btnMoneda5.addActionListener(this);
        btnMoneda2.setFocusPainted(false);

        btnMoneda2.setName("2");
        btnMoneda2.setContentAreaFilled(false);
        ImageIcon icon2 = new ImageIcon(Cobro.class.getResource("/Resources/Images/Moneda 2 pesos.png"));
        Image scaledImage2 = icon2.getImage().getScaledInstance(99, 63, Image.SCALE_SMOOTH);
        btnMoneda2.setIcon(new ImageIcon(scaledImage2));
        btnMoneda2.setBounds(407, 160, 99, 63);
        getContentPane().add(btnMoneda2);
        btnMoneda2.addActionListener(this);
        btnMoneda1.setFocusPainted(false);

        btnMoneda1.setName("1");
        btnMoneda1.setContentAreaFilled(false);
        ImageIcon icon1 = new ImageIcon(Cobro.class.getResource("/Resources/Images/Moneda 1 peso.png"));
        Image scaledImage1 = icon1.getImage().getScaledInstance(99, 63, Image.SCALE_SMOOTH);
        btnMoneda1.setIcon(new ImageIcon(scaledImage1));
        btnMoneda1.setBounds(407, 248, 99, 63);
        getContentPane().add(btnMoneda1);
        btnMoneda1.addActionListener(this);
        btnMoneda50Centavos.setFocusPainted(false);

        btnMoneda50Centavos.setName("0.50");
        btnMoneda50Centavos.setContentAreaFilled(false);
        ImageIcon icon50c = new ImageIcon(Cobro.class.getResource("/Resources/Images/Moneda 50 centavos.png"));
        Image scaledImage50c = icon50c.getImage().getScaledInstance(99, 69, Image.SCALE_SMOOTH);
        btnMoneda50Centavos.setIcon(new ImageIcon(scaledImage50c));
        btnMoneda50Centavos.setBounds(407, 331, 99, 69);
        btnMoneda50Centavos.addActionListener(this);
        getContentPane().add(btnMoneda50Centavos);
        btnNewButton.setEnabled(false);

        btnNewButton.setName("Pagar");
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorder(new LineBorder(new Color(255, 255, 0), 3, true));
        btnNewButton.setBackground(new Color(107, 142, 35));
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(24, 307, 140, 58);

        getContentPane().add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Dinero Ingresado:");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(24, 140, 182, 36);
        getContentPane().add(lblNewLabel);
        lblDineroIngresado.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 20));
        lblDineroIngresado.setBounds(68, 207, 83, 36);

        getContentPane().add(lblDineroIngresado);
        lblDineroAPagar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
        lblDineroAPagar.setBounds(24, 23, 182, 36);

        getContentPane().add(lblDineroAPagar);
        lblDineroaPagar.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 20));
        lblDineroaPagar.setBounds(68, 75, 83, 36);

        getContentPane().add(lblDineroaPagar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(549, 450);

    }

    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();

        switch (sourceButton.getName()) {
            case "200":
                agregardinero(200);
                break;
            case "100":
                agregardinero(100);
                break;
            case "50":
                agregardinero(50);
                break;
            case "20":
                agregardinero(20);
                break;
            case "10":
                agregardinero(10);
                break;
            case "5":
                agregardinero(5);
                break;
            case "2":
                agregardinero(2);
                break;
            case "1":
                agregardinero(1);
                break;
            case "0.50":

                agregardinero(0.50);
                break;
            case "Pagar":
               cS.ListaProductos(productos,this.getDinero());
               cS.getCambio();
               
               
               

               break;
            default:
            // Manejar cualquier otro caso si es necesario
        }
    }

    private void agregardinero(double valor) {
        // Obtén el texto de lblDineroIngresado
        String texto = lblDineroIngresado.getText();

        // Quita el símbolo "$" del texto
        String cantidadSinDolar = texto.substring(1);  // Empieza desde el segundo carácter para omitir el "$"

        // Obtén el texto de lblDineroaPagar
        String texto1 = lblDineroaPagar.getText();

        // Quita el símbolo "$" del texto
        String cantidadSinDolar1 = texto1.substring(1);  // Empieza desde el segundo carácter para omitir el "$"

        // Convierte la cantidad a Double
        try {
            Double dinero = Double.parseDouble(cantidadSinDolar);

            System.out.println(dinero);

            Double dinerototal = dinero + valor;

            // Formatea el nuevo valor como una cadena con el símbolo "$"
            String nuevoTexto = String.format("$%.2f", dinerototal);

            // Establece el nuevo valor en lblDineroIngresado
            lblDineroIngresado.setText(nuevoTexto);

            Double dineroPagado = Double.parseDouble(cantidadSinDolar1);

            System.out.println(dineroPagado);
            System.out.println(dinerototal);

            if (dinerototal >= dineroPagado) {
                btnNewButton.setEnabled(true);
            }

        } catch (NumberFormatException e) {
            // Maneja la excepción si el formato no es válido
            System.err.println("Formato de cantidad no válido");
        }
    }

    public Double getDinero() {
        try {
            String texto = lblDineroIngresado.getText();

            // Quita el símbolo "$" del texto
            String cantidadSinDolar = texto.substring(1);  // Empieza desde el segundo carácter para omitir el "$"

            // Convierte la cantidad a Double
            Double dinero = Double.parseDouble(cantidadSinDolar);

            return dinero;
        } catch (NumberFormatException e) {
            // Manejar la excepción si el formato no es válido
            System.err.println("Formato de cantidad no válido en lblNewLabel_1");
            return null; // o puedes devolver un valor por defecto o lanzar la excepción
        }
    }

    public void SetDinero(Double dinero) {

        String dineroFormateado = NumberFormat.getCurrencyInstance().format(dinero);

        // Establecer el valor formateado en el JLabel
        
        lblDineroaPagar.setText(dineroFormateado);

    }
/*
    public static void main(String[] args) {

        Cobro cobro = new Cobro();

    }
*/
}
