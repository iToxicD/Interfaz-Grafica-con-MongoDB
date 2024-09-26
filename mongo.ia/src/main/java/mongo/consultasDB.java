package mongo;

import org.bson.Document;
import com.mongodb.client.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.conversions.Bson;

public class consultasDB {

	private static MongoCollection<Document> coleccion;

	public consultasDB(MongoCollection<Document> coleccion) {
        this.coleccion = coleccion;
    }
	
	public consultasDB(String url, String nombreBaseDatos, String nombreColeccion) {
        MongoClient client = MongoClients.create(url);
        MongoDatabase db = client.getDatabase(nombreBaseDatos);
        coleccion = db.getCollection(nombreColeccion);
	}
	
	public static void consultasDB(String url, String nombreBaseDatos, String nombreColeccion) {
        MongoClient client = MongoClients.create(url);
        MongoDatabase db = client.getDatabase(nombreBaseDatos);
        coleccion = db.getCollection(nombreColeccion);
	}
	
	public consultasDB() {
		super();
		// TODO Auto-generated constructor stub
	}


	// Añade una IA nueva a la base de datos
    public void insertar(String codigo, String nombre, String tipo, int aparicion, String imagen) {
        Document crear = new Document("_id", codigo).append("nombre", nombre).append("tipo", tipo).append("añoAparicion", aparicion).append("imagen", imagen);
        InsertOneResult result = coleccion.insertOne(crear);
        System.out.println(result.wasAcknowledged());
        System.out.println("Insertado " + result.getInsertedId());
    }
    
    public void actualizar(String codigo, String nuevoNombre, String nuevoTipo, int nuevaAparicion, String nuevaImagen) {
    	Bson nuevo = new Document("set", new Document("nombre", nuevoNombre).append("tipo", nuevoTipo) .append("añoAparicion", nuevaAparicion).append("imagen", nuevaImagen));
    	Document nuevosDatos = new Document("$set", nuevo);
    	UpdateResult salida = coleccion.updateOne(nuevo, nuevosDatos);
    	System.out.println(salida.wasAcknowledged());
        System.out.println("Actualizado " + salida.getModifiedCount());
    }
    
    //Consulta en la base de datos los datos que coincidan con el codigo
    public Document consultar(int codigo) {
    	Bson buscar = new Document("codigo", codigo);
    	return (Document) coleccion.find(buscar);
    }
    
    public void eliminar(int codigo) {
    	Document borrar = new Document("codigo", codigo);
    	DeleteResult elimina = coleccion.deleteOne(borrar);
    }

	
}
