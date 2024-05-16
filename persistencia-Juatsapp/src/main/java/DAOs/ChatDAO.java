package daos;

import DTOs.Chat;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.stream.Collectors;

/**
 *
 * @author eduar
 */
public class ChatDAO {

    private MongoCollection<Document> collection;

    public ChatDAO() {
        MongoDatabase database = persistencia.ConexionBD.getDatabase();
        collection = database.getCollection("chats");
    }

    public void insertarChat(Chat chat) {
        Document doc = new Document("_id", new ObjectId())
                .append("nombre_chat", chat.getNombreChat())
                .append("imagen_miniatura", chat.getImagenMiniatura())
                .append("participantes", chat.getParticipantes());
        collection.insertOne(doc);
    }

    public Chat encontrarChatPorNombre(String nombreChat) {
        Document doc = collection.find(eq("nombre_chat", nombreChat)).first();
        if (doc != null) {
            ObjectId id = doc.getObjectId("_id");
            String nombre = doc.getString("nombre_chat");
            String imagenMiniatura = doc.getString("imagen_miniatura");
            List<String> participantes = doc.getList("participantes", ObjectId.class).stream()
                                            .map(ObjectId::toString)
                                            .collect(Collectors.toList());
            return new Chat(id, nombre, imagenMiniatura, participantes);
        }
        return null;
    }

    public List<Chat> obtenerChatsPorUsuarioId(ObjectId usuarioId) {
        List<Chat> chats = new ArrayList<>();
        for (Document doc : collection.find(Filters.in("participantes", usuarioId))) {
            ObjectId id = doc.getObjectId("_id");
            String nombre = doc.getString("nombre_chat");
            String imagenMiniatura = doc.getString("imagen_miniatura");
            List<String> participantes = doc.getList("participantes", ObjectId.class).stream()
                                            .map(ObjectId::toString)
                                            .collect(Collectors.toList());
            chats.add(new Chat(id, nombre, imagenMiniatura, participantes));
        }
        return chats;
    }

    public UpdateResult actualizarChat(Chat chat) {
        return collection.updateOne(eq("_id", chat.getId()),
                new Document("$set", new Document("nombre_chat", chat.getNombreChat())
                        .append("imagen_miniatura", chat.getImagenMiniatura())
                        .append("participantes", chat.getParticipantes())));
    }

    public DeleteResult eliminarChat(ObjectId id) {
        return collection.deleteOne(eq("_id", id));
    }
}
