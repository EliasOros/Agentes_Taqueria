package Model.Ontologia;


import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.PrimitiveSchema;

public class Ontologia extends Ontology{

	public static final String ONTOLOGY_NAME = "ontología de productos";
	
	public static final String PRODUCTO = "Producto";
	
	public static final String PRODUCTO_NOMBRE = "nombre";
	public static final String PRODUCTO_PRECIO = "precio";
	
	public static final String COMUNICACION = "Comunicacion";
	public static final String OFERTA_FRUTA = "producto";
	 
	public static final String ACCION = "Accion";
	public static final String ACCION_FRUTA = "producto";
	
	private static Ontology instancia = new Ontologia();
	
	private Ontologia() {
		
		super(ONTOLOGY_NAME, BasicOntology.getInstance());
		
		try {
		       // Añade los elementos
		       add(new ConceptSchema(PRODUCTO), Producto.class);
		       add(new PredicateSchema(COMUNICACION), Comunicacion.class);
		       add(new AgentActionSchema(ACCION), Accion.class);
		 
		       // Estructura del esquema para el concepto FRUTA
		       ConceptSchema cs = (ConceptSchema) getSchema(PRODUCTO);
		       cs.add(PRODUCTO_NOMBRE, (PrimitiveSchema) getSchema(BasicOntology.STRING));
		       cs.add(PRODUCTO_PRECIO, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
		 
		       // Estructura del esquema para el predicado OFERTA
		       PredicateSchema ps = (PredicateSchema) getSchema(COMUNICACION);
		       ps.add(OFERTA_FRUTA, (ConceptSchema) getSchema(PRODUCTO));
		 
		       // Estructura del esquema para la acción COMPRAR
		       AgentActionSchema as = (AgentActionSchema) getSchema(ACCION);
		       as.add(ACCION_FRUTA, (ConceptSchema) getSchema(PRODUCTO));
		     }
		     catch (OntologyException oe) {
		       oe.printStackTrace();
		     }
		
		
	}
	
	
}
