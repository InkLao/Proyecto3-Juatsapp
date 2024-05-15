package daos;

import DTOs.Mensaje;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

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

    public void insertaMensaje(Mensaje mensaje) {
        Document doc = new Document("_id", new ObjectId(mensaje.getId()))
                               .append("chat_id", new ObjectId(mensaje.getChatId()))
                               .append("usuario_id", new ObjectId(mensaje.getUsuarioId()))
                               .append("texto_mensaje", mensaje.getTextoMensaje())
                               .append("fecha_hora", mensaje.getFechaHora())
                               .append("imagen", mensaje.getImagen());
        collection.insertOne(doc);
    }

    public List<Mensaje> encuentraMensajesPorChatId(String chatId) {
        List<Mensaje> mensajes = new ArrayList<>();
        for (Document doc : collection.find(Filters.eq("chat_id", new ObjectId(chatId)))) {
            mensajes.add(new Mensaje(
                doc.getObjectId("_id").toString(),
                doc.getObjectId("chat_id").toString(),
                doc.getObjectId("usuario_id").toString(),
                doc.getString("texto_mensaje"),
                doc.getDate("fecha_hora"),
                doc.getString("imagen")
            ));
        }
        return mensajes;
    }

    public UpdateResult actualizaMensaje(Mensaje mensaje) {
        return collection.updateOne(Filters.eq("_id", new ObjectId(mensaje.getId())),
            new Document("$set", new Document("texto_mensaje", mensaje.getTextoMensaje())
                                       .append("imagen", mensaje.getImagen())));
    }

    public DeleteResult eliminaMensaje(String id) {
        return collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
}
