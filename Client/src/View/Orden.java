package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import View.MyTableExample.ButtonEditor;
import View.MyTableExample.ButtonRenderer;
import View.MyTableExample.SpinnerEditor;
import View.MyTableExample.SpinnerRenderer;

public class Orden extends JFrame implements ActionListener {
	
	private String[] columnNames = {"Nombre", "Precio", "Cantidad", "Borrar"};
    private DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    private JTable table = new JTable(model);
    
    private JButton btnHacerPedido = new JButton("Hacer pedido");
    private JButton btnPastor = new JButton("");
    private JButton btnCampechanos = new JButton("");
    private JButton btnSuadero = new JButton("");
    private JButton btnBistecSinQueso = new JButton("");
    private JButton btnAdobadaSinQueso = new JButton("");
    private JButton btnCarneAsadaSinQueso = new JButton("");
    private JButton btnBistecConQueso = new JButton("");
    private JButton btnAdobadaConQueso = new JButton("");
    private JButton btnCarneAsadaConQueso = new JButton("");
    private JButton btnBoingMango = new JButton("");
    private JButton btnBoingGuayaba = new JButton("");
    private JButton btnAguaDeHorchata = new JButton("");
    private JButton btnAguaDeJamaica = new JButton("");
    private JButton btnCocaCola = new JButton("");
    private JButton btnSidralMundet = new JButton("");
    
    private JLabel lblPastor = new JLabel("Pastor");
    private JLabel lblCampechanos = new JLabel("Campechanos");
    private JLabel lblSuadero = new JLabel("Suadero");
    private JLabel lblBistecSinQueso = new JLabel("Bistec sin queso");
    private JLabel lblBoingMango = new JLabel("Boing Mango");
    private JLabel lblBistecConQueso = new JLabel("Bistec con queso");
    private JLabel lblAdobadaSinQueso = new JLabel("Adobada sin queso");
    private JLabel lblAdobadaConQueso = new JLabel("Adobada con queso");
    private JLabel lblCarneAsadaSinQueso = new JLabel("Carne asada sin Queso");
    private JLabel lblSinQueso = new JLabel("sin queso");
    private JLabel lblCarneAsadaConQueso = new JLabel("Carne asada con queso");
    private JLabel lblConQueso = new JLabel("con queso");
    private JLabel lblBoingGuayaba = new JLabel("Boing Guayaba");
    private JLabel lblAguaDeHorchata = new JLabel("Agua de Horchata");
    private JLabel lblAguaDeJamaica = new JLabel("Agua de Jamaica");
    private JLabel lblCocaCola = new JLabel("Coca Cola");
    private JLabel lblSidralMundet = new JLabel("Sidral Mundet");
    
    private JLabel lbPrecioPastor = new JLabel("$15.00 c/u");
    private JLabel lblPrecioCampechano = new JLabel("$20.00 c/u");
    private JLabel lblPrecioSuadero = new JLabel("$15.00 c/u");
    private JLabel lblPrecioBisteSinQueso = new JLabel("$15.00 c/u");
    private JLabel lblPrecioAdobadaSinQueso = new JLabel("$17.00 c/u");
    private JLabel lblPrecioCarneAsadaSinQueso = new JLabel("$15.00 c/u");
    private JLabel lblPrecioBisteConQueso = new JLabel("$22.00 c/u");
    private JLabel lblPrecioAdobadaConQueso = new JLabel("$24.00 c/u");
    private JLabel lblPrecioCarneAsadaConQueso = new JLabel("$22.00 c/u");
    private JLabel lblPrecioBoingMango = new JLabel("$20.00 c/u");
    private JLabel lblPrecioBoingGuayaba = new JLabel("$20.00 c/u");
    private JLabel lblPrecioHorchata = new JLabel("$15.00 c/u");
    private JLabel lblPrecioSuadero_4 = new JLabel("$15.00 c/u");
    private JLabel lblPrecioCocaCola = new JLabel("$20.00 c/u");
    private JLabel lblPrecioSidral = new JLabel("$20.00 c/u");
    
    
    
    
    
    public Orden() {
        getContentPane().setBackground(new Color(255, 102, 51));
        getContentPane().setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(500, 0, 2, 661);
        getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(900, 0, 2, 661);
        getContentPane().add(separator_1);

        btnHacerPedido.setName("Pedido");
        btnHacerPedido.setFocusPainted(false);
        btnHacerPedido.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 25));
        btnHacerPedido.setBackground(new Color(51, 204, 51));
        btnHacerPedido.setBorder(new LineBorder(new Color(255, 255, 0), 3, true));
        btnHacerPedido.setBounds(1046, 582, 174, 56);
        getContentPane().add(btnHacerPedido);
        btnHacerPedido.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBounds(912, 38, 410, 524);
        getContentPane().add(panel);
        panel.setBorder(new LineBorder(new Color(255, 255, 0), 2, true));
        panel.setBackground(new Color(0, 153, 153));
        panel.setLayout(new BorderLayout());

        // Crear el modelo de la tabla
        
        // Crear la tabla y asignar el modelo
         

        // Establecer el color de fondo de las celdas de la tabla
         table.setBackground(new Color(255, 204, 153));
         table.setForeground(Color.BLACK);

        // Añadir la tabla al JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
 
        btnPastor.setName("Pastor");
        ImageIcon iconPastor = new ImageIcon(Orden.class.getResource("/Resources/Images/Pastor.jpg"));
        Image scaledImagePastor = iconPastor.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnPastor.setIcon(new ImageIcon(scaledImagePastor));
        btnPastor.setBounds(21, 21, 133, 109);
        getContentPane().add(btnPastor);
        btnPastor.addActionListener(this);
         
        btnCampechanos.setName("Campechanos");
        ImageIcon iconCampechanos = new ImageIcon(Orden.class.getResource("/Resources/Images/campechanos.jpg"));
        Image scaledImageCampechanos = iconCampechanos.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnCampechanos.setIcon(new ImageIcon(scaledImageCampechanos));
        btnCampechanos.setBounds(184, 21, 133, 109);
        getContentPane().add(btnCampechanos);
        btnCampechanos.addActionListener(this);

        btnSuadero.setName("Suadero");
        ImageIcon iconSuadero = new ImageIcon(Orden.class.getResource("/Resources/Images/suadero.jpg"));
        Image scaledImageSuadero = iconSuadero.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnSuadero.setIcon(new ImageIcon(scaledImageSuadero));
        btnSuadero.setBounds(344, 21, 133, 109);
        getContentPane().add(btnSuadero);
        btnSuadero.addActionListener(this);
        
        btnBistecSinQueso.setName("Bistec sin queso");
        ImageIcon iconBistecSinQueso = new ImageIcon(Orden.class.getResource("/Resources/Images/bistec.jpg"));
        Image scaledImageBistecSinQueso = iconBistecSinQueso.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnBistecSinQueso.setIcon(new ImageIcon(scaledImageBistecSinQueso));
        btnBistecSinQueso.setBounds(21, 220, 133, 109);
        getContentPane().add(btnBistecSinQueso);
        btnBistecSinQueso.addActionListener(this);

        btnAdobadaSinQueso.setName("Adobada sin Queso");
        ImageIcon iconAdobadaSinQueso = new ImageIcon(Orden.class.getResource("/Resources/Images/adobada.jpg"));
        Image scaledImageAdobadaSinQueso = iconAdobadaSinQueso.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnAdobadaSinQueso.setIcon(new ImageIcon(scaledImageAdobadaSinQueso));
        btnAdobadaSinQueso.setBounds(184, 220, 133, 109);
        getContentPane().add(btnAdobadaSinQueso);
        btnAdobadaSinQueso.addActionListener(this);

        btnCarneAsadaSinQueso.setName("Carne Asada sin Queso");
        ImageIcon iconCarneAsadaSinQueso = new ImageIcon(Orden.class.getResource("/Resources/Images/CarneAsada.jpg"));
        Image scaledImageCarneAsadaSinQueso = iconCarneAsadaSinQueso.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnCarneAsadaSinQueso.setIcon(new ImageIcon(scaledImageCarneAsadaSinQueso));
        btnCarneAsadaSinQueso.setBounds(344, 220, 133, 109);
        getContentPane().add(btnCarneAsadaSinQueso);
        btnCarneAsadaSinQueso.addActionListener(this);

        btnBistecConQueso.setName("Bistec con Queso");
        ImageIcon iconBistecConQueso = new ImageIcon(Orden.class.getResource("/Resources/Images/Bistec con queso.jpg"));
        Image scaledImageBistecConQueso = iconBistecConQueso.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnBistecConQueso.setIcon(new ImageIcon(scaledImageBistecConQueso));
        btnBistecConQueso.setBounds(21, 430, 133, 109);
        getContentPane().add(btnBistecConQueso);
        btnBistecConQueso.addActionListener(this);

        btnAdobadaConQueso.setName("Adobada con Queso");
        ImageIcon iconAdobadaConQueso = new ImageIcon(Orden.class.getResource("/Resources/Images/adobada con queso.jpg"));
        Image scaledImageAdobadaConQueso = iconAdobadaConQueso.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnAdobadaConQueso.setIcon(new ImageIcon(scaledImageAdobadaConQueso));
        btnAdobadaConQueso.setBounds(184, 430, 133, 109);
        getContentPane().add(btnAdobadaConQueso);
        btnAdobadaConQueso.addActionListener(this);

        btnCarneAsadaConQueso.setName("Carne Asada con Queso");
        ImageIcon iconCarneAsadaConQueso = new ImageIcon(Orden.class.getResource("/Resources/Images/carne asada con queso.jpg"));
        Image scaledImageCarneAsadaConQueso = iconCarneAsadaConQueso.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnCarneAsadaConQueso.setIcon(new ImageIcon(scaledImageCarneAsadaConQueso));
        btnCarneAsadaConQueso.setBounds(344, 430, 133, 109);
        getContentPane().add(btnCarneAsadaConQueso);
        btnCarneAsadaConQueso.addActionListener(this);

        btnBoingMango.setName("Boing de Mango");
        btnBoingMango.setContentAreaFilled(false);
        ImageIcon iconBoingMango = new ImageIcon(Orden.class.getResource("/Resources/Images/Boing mango.png"));
        Image scaledImageBoingMango = iconBoingMango.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnBoingMango.setIcon(new ImageIcon(scaledImageBoingMango));
        btnBoingMango.setBounds(539, 21, 133, 109);
        getContentPane().add(btnBoingMango);
        btnBoingMango.addActionListener(this);

        btnBoingGuayaba.setName("Boing de Guayaba");
        btnBoingGuayaba.setContentAreaFilled(false);
        ImageIcon iconBoingGuayaba = new ImageIcon(Orden.class.getResource("/Resources/Images/Boing guayaba.png"));
        Image scaledImageBoingGuayaba = iconBoingGuayaba.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnBoingGuayaba.setIcon(new ImageIcon(scaledImageBoingGuayaba));
        btnBoingGuayaba.setBounds(726, 21, 133, 109);
        getContentPane().add(btnBoingGuayaba);
        btnBoingGuayaba.addActionListener(this);

        btnAguaDeHorchata.setName("Agua de Horchata");
        ImageIcon iconAguaDeHorchata = new ImageIcon(Orden.class.getResource("/Resources/Images/Agua-de-Horchata.jpg"));
        Image scaledImageAguaDeHorchata = iconAguaDeHorchata.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnAguaDeHorchata.setIcon(new ImageIcon(scaledImageAguaDeHorchata));
        btnAguaDeHorchata.setBounds(539, 220, 133, 109);
        getContentPane().add(btnAguaDeHorchata);
        btnAguaDeHorchata.addActionListener(this);

        btnAguaDeJamaica.setName("Agua de Jamaica");
        ImageIcon iconAguaDeJamaica = new ImageIcon(Orden.class.getResource("/Resources/Images/agua jamaica.jpg"));
        Image scaledImageAguaDeJamaica = iconAguaDeJamaica.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnAguaDeJamaica.setIcon(new ImageIcon(scaledImageAguaDeJamaica));
        btnAguaDeJamaica.setBounds(726, 220, 133, 109);
        getContentPane().add(btnAguaDeJamaica);
        btnAguaDeJamaica.addActionListener(this);

        btnCocaCola.setName("Coca Cola");
        btnCocaCola.setContentAreaFilled(false);
        ImageIcon iconCocaCola = new ImageIcon(Orden.class.getResource("/Resources/Images/coca.png"));
        Image scaledImageCocaCola = iconCocaCola.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnCocaCola.setIcon(new ImageIcon(scaledImageCocaCola));
        btnCocaCola.setBounds(539, 430, 133, 109);
        getContentPane().add(btnCocaCola);
        btnCocaCola.addActionListener(this);

        btnSidralMundet.setName("Sidral Mundet");
        btnSidralMundet.setContentAreaFilled(false);
        ImageIcon iconSidralMundet = new ImageIcon(Orden.class.getResource("/Resources/Images/sidral.png"));
        Image scaledImageSidralMundet = iconSidralMundet.getImage().getScaledInstance(133, 109, Image.SCALE_SMOOTH);
        btnSidralMundet.setIcon(new ImageIcon(scaledImageSidralMundet));
        btnSidralMundet.setBounds(726, 430, 133, 109);
        getContentPane().add(btnSidralMundet);
        btnSidralMundet.addActionListener(this);

        lblPastor.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPastor.setBounds(31, 141, 123, 27);
        getContentPane().add(lblPastor);

        lblCampechanos.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblCampechanos.setBounds(184, 141, 133, 27);
        getContentPane().add(lblCampechanos);

        lblSuadero.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblSuadero.setBounds(344, 141, 123, 27);
        getContentPane().add(lblSuadero);

        lblBistecSinQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblBistecSinQueso.setBounds(21, 340, 133, 27);
        getContentPane().add(lblBistecSinQueso);

        lblBoingMango.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblBoingMango.setBounds(539, 141, 123, 27);
        getContentPane().add(lblBoingMango);

        lblBistecConQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblBistecConQueso.setBounds(21, 563, 133, 27);
        getContentPane().add(lblBistecConQueso);

        lblAdobadaSinQueso.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblAdobadaSinQueso.setBounds(184, 340, 133, 27);
        getContentPane().add(lblAdobadaSinQueso);

        lblAdobadaConQueso.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblAdobadaConQueso.setBounds(184, 563, 146, 27);
        getContentPane().add(lblAdobadaConQueso);

        lblCarneAsadaSinQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblCarneAsadaSinQueso.setBounds(344, 340, 97, 27);
        getContentPane().add(lblCarneAsadaSinQueso);

        lblSinQueso.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblSinQueso.setBounds(405, 364, 85, 27);
        getContentPane().add(lblSinQueso);

        lblCarneAsadaConQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblCarneAsadaConQueso.setBounds(344, 563, 97, 27);
        getContentPane().add(lblCarneAsadaConQueso);

        lblConQueso.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblConQueso.setBounds(405, 582, 85, 27);
        getContentPane().add(lblConQueso);

        lblBoingGuayaba.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblBoingGuayaba.setBounds(726, 141, 123, 27);
        getContentPane().add(lblBoingGuayaba);

        lblAguaDeHorchata.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAguaDeHorchata.setBounds(539, 349, 161, 27);
        getContentPane().add(lblAguaDeHorchata);

        lblAguaDeJamaica.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAguaDeJamaica.setBounds(726, 349, 146, 27);
        getContentPane().add(lblAguaDeJamaica);

        lblCocaCola.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblCocaCola.setBounds(539, 563, 123, 27);
        getContentPane().add(lblCocaCola);

        lblSidralMundet.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblSidralMundet.setBounds(726, 563, 123, 27);
        getContentPane().add(lblSidralMundet);
        
        lbPrecioPastor.setForeground(new Color(0, 0, 102));
        lbPrecioPastor.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lbPrecioPastor.setBounds(68, 167, 123, 27);
        getContentPane().add(lbPrecioPastor);
        
        lblPrecioCampechano.setForeground(new Color(0, 0, 102));
        lblPrecioCampechano.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioCampechano.setBounds(224, 167, 123, 27);
        getContentPane().add(lblPrecioCampechano);
        
        lblPrecioSuadero.setForeground(new Color(0, 0, 102));
        lblPrecioSuadero.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioSuadero.setBounds(367, 167, 123, 27);
        getContentPane().add(lblPrecioSuadero);
        
        lblPrecioBisteSinQueso.setForeground(new Color(0, 0, 102));
        lblPrecioBisteSinQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioBisteSinQueso.setBounds(68, 373, 123, 27);
        getContentPane().add(lblPrecioBisteSinQueso);
        
        lblPrecioAdobadaSinQueso.setForeground(new Color(0, 0, 102));
        lblPrecioAdobadaSinQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioAdobadaSinQueso.setBounds(224, 373, 123, 27);
        getContentPane().add(lblPrecioAdobadaSinQueso);
        
        lblPrecioCarneAsadaSinQueso.setForeground(new Color(0, 0, 102));
        lblPrecioCarneAsadaSinQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioCarneAsadaSinQueso.setBounds(379, 392, 123, 27);
        getContentPane().add(lblPrecioCarneAsadaSinQueso);
        
        lblPrecioBisteConQueso.setForeground(new Color(0, 0, 102));
        lblPrecioBisteConQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioBisteConQueso.setBounds(68, 601, 123, 27);
        getContentPane().add(lblPrecioBisteConQueso);
        
        lblPrecioAdobadaConQueso.setForeground(new Color(0, 0, 102));
        lblPrecioAdobadaConQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioAdobadaConQueso.setBounds(235, 601, 123, 27);
        getContentPane().add(lblPrecioAdobadaConQueso);
        
        lblPrecioCarneAsadaConQueso.setForeground(new Color(0, 0, 102));
        lblPrecioCarneAsadaConQueso.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioCarneAsadaConQueso.setBounds(379, 620, 123, 27);
        getContentPane().add(lblPrecioCarneAsadaConQueso);
        
        lblPrecioBoingMango.setForeground(new Color(0, 0, 102));
        lblPrecioBoingMango.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioBoingMango.setBounds(577, 176, 123, 27);
        getContentPane().add(lblPrecioBoingMango);
        
        lblPrecioBoingGuayaba.setForeground(new Color(0, 0, 102));
        lblPrecioBoingGuayaba.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioBoingGuayaba.setBounds(772, 176, 123, 27);
        getContentPane().add(lblPrecioBoingGuayaba);
        
        lblPrecioHorchata.setForeground(new Color(0, 0, 102));
        lblPrecioHorchata.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioHorchata.setBounds(591, 387, 123, 27);
        getContentPane().add(lblPrecioHorchata);
        
        lblPrecioSuadero_4.setForeground(new Color(0, 0, 102));
        lblPrecioSuadero_4.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioSuadero_4.setBounds(779, 387, 123, 27);
        getContentPane().add(lblPrecioSuadero_4);
        
        
        lblPrecioCocaCola.setForeground(new Color(0, 0, 102));
        lblPrecioCocaCola.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioCocaCola.setBounds(591, 591, 123, 27);
        getContentPane().add(lblPrecioCocaCola);
        
        lblPrecioSidral.setForeground(new Color(0, 0, 102));
        lblPrecioSidral.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblPrecioSidral.setBounds(789, 591, 123, 27);
        getContentPane().add(lblPrecioSidral);

        table.getColumnModel().getColumn(2).setCellRenderer(new SpinnerRenderer());

        // Configura el editor para el JSpinner
        SpinnerEditor spinnerEditor = new SpinnerEditor(new JSpinner());
        table.getColumnModel().getColumn(2).setCellEditor(spinnerEditor);

        // Configura la acción para el botón "Eliminar"
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        ButtonEditor buttonEditor = new ButtonEditor(new JCheckBox());
        table.getColumnModel().getColumn(3).setCellEditor(buttonEditor);
        
        // Añadir una fila de ejemplo al modelo
        // model.addRow(new Object[]{"Ejemplo Nombre", 10.0, 2, "Eliminar"});

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 700);
    }

        
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();

        switch (sourceButton.getName()) {
            case "Pastor":
            	
            	if (verificarEnTabla(lblPastor.getText()) == false) {
            		
            		model.addRow(new Object[]{lblPastor.getText(), lbPrecioPastor.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Campechanos":
            	
            	if (verificarEnTabla(lblCampechanos.getText()) == false) {
            		
            	    model.addRow(new Object[]{lblCampechanos.getText(), lblPrecioCampechano.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Suadero":
            	
            	if (verificarEnTabla(lblSuadero.getText()) == false) {
                
            		model.addRow(new Object[]{lblSuadero.getText(), lblPrecioSuadero.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Bistec sin queso":
            	
            	if (verificarEnTabla(lblBistecSinQueso.getText()) == false) {
               
            		model.addRow(new Object[]{lblBistecSinQueso.getText(), lblPrecioBisteSinQueso.getText(), 1, "Eliminar"});
            	
            	}
                break;
            case "Adobada sin Queso":
            	
            	if (verificarEnTabla(lblAdobadaSinQueso.getText()) == false) {
                
            		model.addRow(new Object[]{lblAdobadaSinQueso.getText(), lblPrecioAdobadaSinQueso.getText(), 1, "Eliminar"});
            	
            	}
                break;
            case "Carne Asada sin Queso":
            	
            	if (verificarEnTabla(lblCarneAsadaSinQueso.getText()) == false) {
                
            		model.addRow(new Object[]{lblCarneAsadaSinQueso.getText(), lblPrecioCarneAsadaSinQueso.getText(), 1, "Eliminar"});
            	
            	}
                break;
            case "Bistec con Queso":
            	
            	if (verificarEnTabla(lblBistecConQueso.getText()) == false) {
                
            		model.addRow(new Object[]{lblBistecConQueso.getText(), lblPrecioBisteConQueso.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Adobada con Queso":
            	
            	if (verificarEnTabla(lblAdobadaConQueso.getText()) == false) {
                
            		model.addRow(new Object[]{lblAdobadaConQueso.getText(), lblPrecioAdobadaConQueso.getText(), 1, "Eliminar"});
            	
            	}
                break;
            case "Carne Asada con Queso":
            	
            	if (verificarEnTabla(lblCarneAsadaConQueso.getText()) == false) {
                
            		model.addRow(new Object[]{lblCarneAsadaConQueso.getText(), lblPrecioCarneAsadaConQueso.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Boing de Mango":
            	
            	if (verificarEnTabla(lblBoingMango.getText()) == false) {
                
            		model.addRow(new Object[]{lblBoingMango.getText(), lblPrecioBoingMango.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Boing de Guayaba":
            	
            	if (verificarEnTabla(lblBoingGuayaba.getText()) == false) {
                
            		model.addRow(new Object[]{lblBoingGuayaba.getText(), lblPrecioBoingGuayaba.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Agua de Horchata":
            	
            	if (verificarEnTabla(lblAguaDeHorchata.getText()) == false) {
                
            		model.addRow(new Object[]{lblAguaDeHorchata.getText(), lblPrecioHorchata.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Agua de Jamaica":
            	
            	if (verificarEnTabla(lblAguaDeJamaica.getText()) == false) {
               
            		model.addRow(new Object[]{lblAguaDeJamaica.getText(), lblPrecioSuadero_4.getText(), 1, "Eliminar"});
            		
            	}
                break;
            case "Coca Cola":
            	
            	if (verificarEnTabla(lblCocaCola.getText()) == false) {
            		
            		model.addRow(new Object[]{lblCocaCola.getText(), lblPrecioCocaCola.getText(), 1, "Eliminar"});
                
            	}
                break;
            case "Sidral Mundet":
            	            	
            	if (verificarEnTabla(lblSidralMundet.getText()) == false) {
 
            		model.addRow(new Object[]{lblSidralMundet.getText(), lblPrecioSidral.getText(), 1, createDeleteButton()});
                
            	}
                break;
            // Agrega más casos según las demás opciones...
        }
    }
    
    public boolean verificarEnTabla(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < model.getRowCount(); i++) {
            String nombreTabla = (String) model.getValueAt(i, 0);

            if (nombreTabla.equals(nombre)) {
                // Si encontramos el nombre, aumentar la cantidad en 1
                int cantidad = (int) model.getValueAt(i, 2);
                model.setValueAt(cantidad + 1, i, 2);
                encontrado = true;
                break;
            }
        }

        return encontrado;
    }
    
    private JSpinner createSpinner() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        return new JSpinner(spinnerModel);
    }

    private JButton createDeleteButton() {
        JButton deleteButton = new JButton("Borrar");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila y eliminarla al hacer clic en el botón de borrar
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                }
            }
        });
        return deleteButton;
    }


    class SpinnerRenderer extends JSpinner implements TableCellRenderer {
        public SpinnerRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setValue(value);
            return this;
        }
    }

    class SpinnerEditor extends DefaultCellEditor {
        private JSpinner spinner;

        public SpinnerEditor(JSpinner spinner) {
            super(new JTextField()); // Utiliza un JTextField como editor por defecto
            this.spinner = spinner;
            setClickCountToStart(1); // Haz clic para iniciar la edición
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }

        @Override
        public Object getCellEditorValue() {
            return spinner.getValue();
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Eliminar");
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private JButton button;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("Eliminar");
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int modelRow = table.convertRowIndexToModel(table.getEditingRow());
                    if (modelRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(modelRow);
                        fireEditingStopped();
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Orden());
    }
}