/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class Venta extends Producto{
    protected int cantidad;
    protected double total;
    
    public Venta(){
        super();
    }
    
    public Venta(Double total){
        this.total = total;
    }
    
    public Venta(int id, String nombre, String marca, float precio, int cantidad, double total){
        super(id, nombre, marca, precio);
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    

    
    
    @Override
    public String toString(){
        return this.nombre + "\t" + this.marca + "\t" + this.cantidad + "\t" + this.total;
    }
    
}
