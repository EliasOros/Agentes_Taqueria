package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelo.Venta;
import Interfaz.InterfazCliente;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class ControladorCliente implements ActionListener{
    protected InterfazCliente vista;
    public ArrayList<Venta> pedido_pizzas;
    public String pedido = "";
    public double pago_final = 0;
    DecimalFormat formato = new DecimalFormat("#.00");
    
    public ControladorCliente(InterfazCliente vista){
        this.vista = vista;        
    }
    
    public void iniciar() {
        vista.setVisible(true);
        this.vista.agregar.setActionCommand("agregar");
        this.vista.agregar.addActionListener(this);
        this.vista.pagar.setActionCommand("pagar");
        this.vista.pagar.addActionListener(this);
        this.vista.solicitar.setActionCommand("solicitar");
        this.vista.solicitar.addActionListener(this);
        pedido_pizzas = new ArrayList<>();
    }
    
    public void solicitarCompra(){
        pedido = "Pizza\tTamaño\tCantidad\tP/Unitario\tSubtotal\n";
        for(Venta v : pedido_pizzas){
            pedido += v.getNombre()+"\t"+v.getMarca()+"\t"+v.getCantidad()+"\t"+v.getPrecio()+"\t"+formato.format(v.getTotal()) +
                    ",\n";
        }
        pago_final = Double.parseDouble(vista.total.getText());
        JOptionPane.showMessageDialog(null, "Sus pizzas estan siendo horneadas");
        pedido_pizzas.clear();
        vista.pagar.setEnabled(true);
    }
    
    public void pagar(){
        try {
            Socket socket = new Socket("192.168.1.1",5000);
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            String efectivo = vista.efectivo.getText();
            salida.writeUTF(pedido + efectivo + "," + pago_final);
            salida.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
        }
        vista.total.setText("");
        vista.efectivo.setText("");
        pedido_pizzas = new ArrayList<>();
    }
    
    public void agregarProducto(){
        
        Venta v = new Venta();
        int id = Integer.parseInt(this.vista.id.getText());
        int cantidad = Integer.parseInt(this.vista.cantidad.getText());
        v.setId(id);
        v.setNombre(vista.lista_productos.get(id-1).getNombre());
        v.setMarca(vista.lista_productos.get(id-1).getMarca());
        v.setPrecio(vista.lista_productos.get(id-1).getPrecio());
        v.setCantidad(cantidad);
        v.setTotal(vista.lista_productos.get(id-1).getPrecio()*cantidad);
        pedido_pizzas.add(v);
        JOptionPane.showMessageDialog(null,"Pizza: "  + v.getNombre()+
                                                        "\nTamaño:  " + v.getMarca() + 
                                                        "\nCantidad: " + v.getCantidad() +
                                                        "\nPrecio unitario: " + v.getPrecio()+ 
                                                        "\nTotal: " + formato.format(v.getTotal()) + 
                                                        "\n\nPizza agregada a la orden");
        double montoFinal = 0;
        for(Venta venta : pedido_pizzas){
            montoFinal += venta.getTotal();
        }
        vista.panelGeneral.remove(vista.tablaVenta);
        vista.mostrarCompra(pedido_pizzas);
        vista.total.setText(formato.format(montoFinal) + "");
        vista.cantidad.setText("");
        vista.id.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch(comando){
            case "agregar":
                agregarProducto();
            break;
            case "solicitar":
                solicitarCompra();
            break;
            case "pagar":
                pagar();
            break;
            default:
            break;
        }
    }
    
}
