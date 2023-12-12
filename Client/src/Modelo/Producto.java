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

public class Producto {
    protected int id;
    protected String nombre;
    protected String marca;
    protected float precio;
    
    public Producto(){
        
    }
    
    public Producto(int id, String nombre, String marca, float precio){
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
    @Override
    public String toString(){
        return this.id + "\t" + this.nombre + "\t" + this.marca + "\t" + this.precio;
    }
    
    
}
