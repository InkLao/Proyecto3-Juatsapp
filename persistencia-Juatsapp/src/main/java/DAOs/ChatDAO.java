package daos;

import DTOs.Chat;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import interfaces.IChatDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author eduar
 */
public class ChatDAO implements IChatDAO {

    private MongoCollection<Document> collection;

    public ChatDAO() {
        MongoDatabase database = persistencia.ConexionBD.getDatabase();
        collection = database.getCollection("chats");
    }

    @Override
    public void insertarChat(Chat chat) {
        Document doc = new Document("_id", new ObjectId())
                .append("nombre_chat", chat.getNombreChat())
                .append("imagen_miniatura", chat.getImagenMiniatura())
                .append("participantes", chat.getParticipantes());
        collection.insertOne(doc);
    }

    @Override
    public Chat encontrarChatPorNombre(String nombreChat) {
        Document doc = collection.find(eq("nombre_chat", nombreChat)).first();
        if (doc != null) {
            ObjectId id = doc.getObjectId("_id");
            String nombre = doc.getString("nombre_chat");
            String imagenMiniatura = doc.getString("imagen_miniatura");
            List<String> participantes = doc.getList("participantes", String.class);
            return new Chat(id, nombre, imagenMiniatura, participantes);
        }
        return null;
    }

    @Override
    public UpdateResult actualizarChat(Chat chat) {
        return collection.updateOne(eq("_id", chat.getId()),
                new Document("$set", new Document("nombre_chat", chat.getNombreChat())
                        .append("imagen_miniatura", chat.getImagenMiniatura())
                        .append("participantes", chat.getParticipantes())));
    }

    @Override
    public DeleteResult eliminarChat(ObjectId id) {
        return collection.deleteOne(eq("_id", id));
    }

    public List<Chat> obtenerChatsPorParticipante(String participanteId) {
        List<Chat> chats = new ArrayList<>();
        List<Document> docs = collection.find(in("participantes", participanteId)).into(new ArrayList<>());
        for (Document doc : docs) {
            ObjectId id = doc.getObjectId("_id");
            String nombre = doc.getString("nombre_chat");
            String imagenMiniatura = doc.getString("imagen_miniatura");
            List<String> participantes = doc.getList("participantes", String.class);
            chats.add(new Chat(id, nombre, imagenMiniatura, participantes));
        }
        return chats;
    }
    
    
}
