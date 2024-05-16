package daos;

import DTOs.Mensaje;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import java.util.Date;

/**
 *
 * @author eduar
 */
public class MensajeDAO {

    private MongoCollection<Document> collection;

    public MensajeDAO() {
        MongoDatabase database = persistencia.ConexionBD.getDatabase();
        collection = database.getCollection("mensajes");
    }

    public void insertarMensaje(Mensaje mensaje) {
    if (mensaje.getFechaHora() == null) {
        mensaje.setFechaHora(new Date()); // Establecer la fecha actual si es nula
    }
    Document doc = new Document()
        .append("chat_id", mensaje.getChatId()) 
        .append("usuario_id", mensaje.getUsuarioId()) 
        .append("texto_mensaje", mensaje.getTextoMensaje())
        .append("fecha_hora", mensaje.getFechaHora())
        .append("imagen", mensaje.getImagen());
    collection.insertOne(doc);
    System.out.println("Mensaje insertado correctamente.");
}


//    public List<Mensaje> obtenerMensajesPorChatId(ObjectId chatId) {
//        List<Mensaje> mensajes = new ArrayList<>();
//        for (Document doc : collection.find(eq("chat_id", chatId))) {
//            ObjectId id = doc.getObjectId("_id");
//            ObjectId chatIdDoc = doc.getObjectId("chat_id");
//            ObjectId usuarioId = doc.getObjectId("usuario_id");
//            String textoMensaje = doc.getString("texto_mensaje");
//            Date fechaHora = doc.getDate("fecha_hora");
//            String imagen = doc.getString("imagen");
//            mensajes.add(new Mensaje(id, chatIdDoc, usuarioId, textoMensaje, fechaHora, imagen));
//        }
//        return mensajes;
//    }

    public DeleteResult eliminarMensaje(ObjectId id) {
        DeleteResult result = collection.deleteOne(eq("_id", id));
        System.out.println("Mensaje eliminado correctamente.");
        return result;
    }
    
    public List<Mensaje> obtenerMensajesPorChatId(ObjectId chatId) {
    List<Mensaje> mensajes = new ArrayList<>();
    List<Document> docs = collection.find(eq("chat_id", chatId)).into(new ArrayList<>());
    for (Document doc : docs) {
        Mensaje mensaje = new Mensaje(
            doc.getObjectId("_id"),
            doc.getObjectId("chat_id"),
            doc.getObjectId("usuario_id"),
            doc.getString("texto_mensaje"),
            doc.getDate("fecha_hora"),
            doc.getString("imagen")
        );
        mensajes.add(mensaje);
    }
    return mensajes;
}


}
