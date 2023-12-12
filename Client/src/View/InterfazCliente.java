package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Producto;
import Model.Venta;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class InterfazCliente extends JFrame{
    public Panel1 panelGeneral;
    public Panel2 panel_se;
    public JTextArea area_texto;
    public JTextField id;
    public JTextField cantidad;
    public JTextField total;
    public JTextField efectivo;
    public JButton agregar;
    public JButton solicitar;
    public JButton pagar;
    
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static DefaultTableModel modelo;
    public JScrollPane tablaProductos;
    public JScrollPane tablaVenta;
    
    public ArrayList<Producto> lista_productos;
    
    public InterfazCliente(){
        super("Pizzeria Italiana");
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setContentPane(agregarPanel());
        this.getProductos();
        this.obtenerMenu(lista_productos);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private JPanel agregarPanelSE (){
        this.panel_se = new Panel2();
        panel_se.setLayout(null);
        panel_se.setBounds(815, 10, 530, 650);
        return panel_se;
    }
    
    private JPanel agregarPanel(){
        this.panelGeneral = new Panel1();
        panelGeneral.setLayout(null);
        panelGeneral.setBounds(10, 10, 1200, 800);
        
        JLabel etqId = new JLabel("ID");
        etqId.setBounds(110, 320, 20, 30);
        
        id = new JTextField();
        id.setBounds(130, 320, 100, 30);
        
        JLabel etqCantidad = new JLabel("CANTIDAD");
        etqCantidad.setBounds(63, 360, 60, 30);
        
        cantidad = new JTextField();
        cantidad.setBounds(130, 360, 100, 30);
        
        agregar = new JButton("Agregar");
        agregar.setBounds(300, 320, 80, 30);
        
        solicitar = new JButton("Hacer pedido");
        solicitar.setBounds(300, 360, 110, 30);
        
        JLabel etqTotal = new JLabel("TOTAL");
        etqTotal.setBounds(450, 320, 60, 30);
        
        total = new JTextField();
        total.setBounds(510, 320, 100, 30);
        total.setEditable(false);
        
        JLabel etqEfectivo = new JLabel("EFECTIVO");
        etqEfectivo.setBounds(450, 360, 60, 30);
        
        efectivo = new JTextField();
        efectivo.setBounds(510, 360, 100, 30);
        
        pagar = new JButton("Pagar");
        pagar.setBounds(300, 400, 80, 30);
        pagar.setEnabled(false);
        
        panelGeneral.add(etqId);
        panelGeneral.add(id);
        panelGeneral.add(etqCantidad);
        panelGeneral.add(cantidad);
        panelGeneral.add(agregar);
        panelGeneral.add(etqTotal);
        panelGeneral.add(total);
        panelGeneral.add(etqEfectivo);
        panelGeneral.add(efectivo);
        panelGeneral.add(solicitar);
        panelGeneral.add(pagar);
        panelGeneral.add(agregarPanelSE());
        
        tablaProductos = new JScrollPane();
        tablaVenta = new JScrollPane();
        
        return panelGeneral;
    }
    
    public final void obtenerMenu(ArrayList<Producto> productos) {
        String[] registros = new String[4];
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("TIPO PIZZA");
        modelo.addColumn("TAMAÑO");
        modelo.addColumn("PRECIO");
        for(int i=0; i<productos.size(); i++) {
            registros[0] = productos.get(i).getId() + "";
            registros[1] = productos.get(i).getNombre();
            registros[2] = productos.get(i).getMarca();
            registros[3] = productos.get(i).getPrecio() + "";
            modelo.addRow(registros);
        }
		
        JTable tabla = new JTable(modelo);
        tabla.setModel(modelo);
        tabla.setFont(new Font("Arial",0,13));
        tabla.setEnabled(true);
		
        DefaultTableCellRenderer Alinear = new MiRender();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        for(int i=0; i<4; i++) {
                tabla.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }

        tablaProductos = new JScrollPane(tabla);
        tablaProductos.setBounds(10,10,800,295);
        
        this.panelGeneral.add(tablaProductos);      
    }
    
    public final void mostrarCompra(ArrayList<Venta> ventas) {
        DecimalFormat formato = new DecimalFormat("#.00");
        String[] registros = new String[4];
        modelo = new DefaultTableModel();
        modelo.addColumn("TIPO PIZZA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        for(int i=0; i<ventas.size(); i++) {
            registros[0] = ventas.get(i).getNombre();
            registros[1] = ventas.get(i).getPrecio() + "";
            registros[2] = ventas.get(i).getCantidad() + "";
            registros[3] = formato.format(ventas.get(i).getTotal()) + "";
            modelo.addRow(registros);
        }
		
        JTable tabla = new JTable(modelo);
        tabla.setModel(modelo);
        tabla.setFont(new Font("Arial",0,13));
        tabla.setEnabled(true);
		
        DefaultTableCellRenderer Alinear = new MiRender();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        for(int i=0; i<4; i++) {
                tabla.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }

        tablaVenta = new JScrollPane(tabla);
        tablaVenta.setBounds(10,450,800,250);
        
        this.panelGeneral.add(tablaVenta);      
    }
    
    public final void getProductos(){
        lista_productos = new ArrayList<>();
        
        lista_productos.add(new Producto(1, "Queso", "Chica", (float)89.99));
        lista_productos.add(new Producto(2, "Queso", "Mediana", (float)119.99));
        lista_productos.add(new Producto(3, "Queso", "Grande", (float)149.99));
        lista_productos.add(new Producto(4, "Pepperoni", "Chica", (float)89.99));
        lista_productos.add(new Producto(5, "Pepperoni", "Mediana", (float)119.99));
        lista_productos.add(new Producto(6, "Pepperoni", "Grande", (float)149.99));
        lista_productos.add(new Producto(7, "Hawaiana", "Chica", (float)99.99));
        lista_productos.add(new Producto(8, "Hawaiana", "Mediana", (float)129.99));
        lista_productos.add(new Producto(9, "Hawaiana", "Grande", (float)169.99));
        lista_productos.add(new Producto(10, "Carne", "Chica", (float)109.99));
        lista_productos.add(new Producto(11, "Carne", "Mediana", (float)149.99));
        lista_productos.add(new Producto(12, "Carne", "Grande", (float)199.99));
        lista_productos.add(new Producto(13, "Jamón", "Chica", (float)69.90));
        lista_productos.add(new Producto(14, "Jamón", "Mediana", (float)99.90));
        lista_productos.add(new Producto(15, "Jamón", "Grande", (float)129.99));
    }
    
    
}
