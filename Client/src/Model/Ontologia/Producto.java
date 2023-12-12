package Model.Ontologia;

import jade.content.Concept;

public class Producto implements Concept{

	private String nombre;
	private String precio;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
		
}
