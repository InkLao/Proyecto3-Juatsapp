package daos;

import DTOs.Chat;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;

/**
 * Test
 * @author eduar
 */
public class ChatDAO {
    private MongoCollection<Document> collection;

    public ChatDAO() {
        MongoDatabase database = persistencia.ConexionBD.getDatabase();
        collection = database.getCollection("chat");
    }

    public void insertarChat(Chat chat) {
        Document doc = new Document("_id", new ObjectId(chat.getId()))
                               .append("nombre_chat", chat.getNombreChat())
                               .append("imagen_miniatura", chat.getImagenMiniatura())
                               .append("participantes", chat.getParticipantes());
        collection.insertOne(doc);
    }

    public Chat encontrarChatById(String id) {
        Document doc = collection.find(eq("_id", new ObjectId(id))).first();
        return doc != null ? new Chat(
            doc.getObjectId("_id").toString(),
            doc.getString("nombre_chat"),
            doc.getString("imagen_miniatura"),
            doc.getList("participantes", String.class)
        ) : null;
    }

    public UpdateResult actualizaChat(Chat chat) {
        return collection.updateOne(eq("_id", new ObjectId(chat.getId())),
            new Document("$set", new Document("nombre_chat", chat.getNombreChat())
                                       .append("imagen_miniatura", chat.getImagenMiniatura())
                                       .append("participantes", chat.getParticipantes())));
    }

    public DeleteResult eliminaChat(String id) {
        return collection.deleteOne(eq("_id", new ObjectId(id)));
    }
}
