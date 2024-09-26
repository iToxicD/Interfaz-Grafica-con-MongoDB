package mongo;

import org.bson.Document;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.conversions.Bson;

public class consultasDB {

	private MongoCollection<Document> coleccion;

	public consultasDB(MongoCollection<Document> coleccion) {
        this.coleccion = coleccion;
    }
	
	public consultasDB() {
		
	}

	// Añade una IA nueva a la base de datos
    public void insertar(int codigo, String nombre, String tipo, int aparicion, String imagen) {
        Document crear = new Document("codigo", codigo).append("nombre", nombre).append("tipo", tipo).append("añoAparicion", aparicion).append("imagen", imagen);
        coleccion.insertOne(crear);
    }
    
    public void actualizar(int codigo, String nuevoNombre, String nuevoTipo, int nuevaAparicion, String nuevaImagen) {
    	Bson nuevo = new Document("set", new Document("nombre", nuevoNombre).append("tipo", nuevoTipo) .append("añoAparicion", nuevaAparicion).append("imagen", nuevaImagen));
    	Document nuevosDatos = new Document("$set", nuevo);
    	UpdateResult salida = coleccion.updateOne(nuevo, nuevosDatos);
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
