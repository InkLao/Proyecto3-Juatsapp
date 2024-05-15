package daos;

import DTOs.Mensaje;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import interfaces.IMensajeDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * 
 * @author eduar
 */
public class MensajeDAO implements IMensajeDAO{
    private MongoCollection<Document> collection;

    public MensajeDAO() {
        MongoDatabase database = persistencia.ConexionBD.getDatabase();
        collection = database.getCollection("mensajes");
    }

    @Override
public void insertarMensaje(Mensaje mensaje) {
    Document doc = new Document()
        .append("chat_id", mensaje.getChatId()) 
        .append("usuario_id", mensaje.getUsuarioId()) 
        .append("texto_mensaje", mensaje.getTextoMensaje())
        .append("fecha_hora", mensaje.getFechaHora())
        .append("imagen", mensaje.getImagen());
    collection.insertOne(doc);
    System.out.println("Mensaje insertado correctamente.");
}


    @Override
    public DeleteResult eliminarMensaje(ObjectId id) {
        DeleteResult result = collection.deleteOne(eq("_id", id));
        System.out.println("Mensaje eliminado correctamente.");
        return result;
    }
}
