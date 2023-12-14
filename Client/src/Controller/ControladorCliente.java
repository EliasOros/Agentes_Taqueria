package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.Agent.Mesero;
import Model.Ontologia.Producto;
import Model.Vender.Prod;
import View.InterfazCli;
import View.Orden;
import View.Principal;



public class ControladorCliente {
    protected InterfazCli vista;
    private Orden Ord;
    private ArrayList<Prod> pedido;
    private Principal p = new Principal();
    private ControladorCliente cc;
    public double pago_final = 0;
    DecimalFormat formato = new DecimalFormat("#.00");

    public ArrayList<Prod> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Prod> pedido) {
        this.pedido = pedido;
    }

    public ControladorCliente getCc() {
        return cc;
    }

    public void setCc(ControladorCliente cc) {
        this.cc = cc;
    }
    
    public void obtenerPedido(){
        
        setCc(p.getCc());
        
    }
    
    /*
    
    
    public static void ObtenerOrden(ArrayList<Prod> pedido){
    	Runtime rt = Runtime.instance();
    	Profile profile = new ProfileImpl();
    	//profile.setParameter(Profile.MAIN_HOST, "");//Direccion IP de la computadora
    	//profile.setParameter(Profile.MAIN_PORT, "");//Puerto
    	
    	ContainerController cc = rt.createMainContainer(profile);
    	System.out.println("Entro a la container");
    	try {
    		
			AgentController a = cc.createNewAgent("Mesero", "src.Model.Agent.Mesero", new Object[] {pedido});
			System.out.println("Entro a la crecion de un agente");
		} catch (StaleProxyException e) {
			e.printStackTrace();
			System.out.println(e);
		}
    }
    
    /*
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
                //agregarProducto();
            break;
            case "solicitar":
               // solicitarCompra();
            break;
            case "pagar":
               // pagar();
            break;
            default:
            break;
        }
    }
    */
    public ControladorCliente() {
        
    }
    public ControladorCliente(String a) {
        p.setVisible(true); 
    }
    
    
}
