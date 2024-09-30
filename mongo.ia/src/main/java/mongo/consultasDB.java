package mongo;

import java.util.Collection;

import org.bson.Document;
import com.mongodb.client.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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
	}


	// Añade una IA nueva a la base de datos
    public void insertar(String codigo, String nombre, String tipo, int aparicion, String imagen) {
        Document crear = new Document("_id", codigo).append("nombre", nombre).append("tipo", tipo).append("añoAparicion", aparicion).append("imagen", imagen);
        InsertOneResult result = coleccion.insertOne(crear);
        
        System.out.println(result.wasAcknowledged());
        System.out.println("Insertado " + result.getInsertedId());
    }
    
    public void actualizar(String codigo, String nuevoNombre, String nuevoTipo, int nuevaAparicion, String nuevaImagen) {
    	Bson filtro = Filters.eq("_id", codigo);
    	Bson nuevo = new Document("$set", new Document("nombre", nuevoNombre).append("tipo", nuevoTipo) .append("añoAparicion", nuevaAparicion).append("imagen", nuevaImagen));
    	UpdateResult salida = coleccion.updateOne(filtro, nuevo);
  
    	System.out.println(salida.wasAcknowledged());
        System.out.println("Actualizado " + salida.getModifiedCount());
    }
    
    //Consulta en la base de datos los datos que coincidan con el codigo
    public Document consultar(String tipo) {
    	Bson filtro = Filters.eq("tipo", tipo);
    	Document resultado = coleccion.find(filtro).first();
    	return resultado;
   
    }
    
    public void eliminar(String codigo) {
    	Bson filtro = Filters.eq("_id", codigo);
    	DeleteResult elimina = coleccion.deleteOne(filtro);
    }	
}
