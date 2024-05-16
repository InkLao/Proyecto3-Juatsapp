package daos;

import DTOs.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import interfaces.IUsuarioDAO;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class UsuarioDAO implements IUsuarioDAO {

    private MongoCollection<Document> collection;

    public UsuarioDAO() {
        MongoDatabase database = persistencia.ConexionBD.getDatabase();
        collection = database.getCollection("usuario");
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        Document doc = new Document("telefono", usuario.getTelefono())
                .append("nombre", usuario.getNombre())
                .append("contrasena_encriptada", usuario.getContrasenaEncriptada())
                .append("fecha_nacimiento", usuario.getFechaNacimiento())
                .append("imagen_perfil", usuario.getImagenPerfil())
                .append("direccion", usuario.getDireccion())
                .append("sexo", usuario.getSexo());
        collection.insertOne(doc);
    }

    @Override
    public Usuario encuentraUsuarioPorTelefono(String telefono) {
        Document doc = collection.find(eq("telefono", telefono)).first();
        return doc != null ? new Usuario(
                doc.getObjectId("_id"),
                doc.getString("telefono"),
                doc.getString("nombre"),
                doc.getString("contrasena_encriptada"),
                doc.getDate("fecha_nacimiento"),
                doc.get("imagen_perfil", Binary.class),
                doc.getString("direccion"),
                doc.getString("sexo")
        ) : null;
    }

    @Override
    public UpdateResult actualizarUsuario(Usuario usuario) {
        return collection.updateOne(eq("telefono", usuario.getTelefono()),
                new Document("$set", new Document("nombre", usuario.getNombre())
                        .append("contrasena_encriptada", usuario.getContrasenaEncriptada())
                        .append("fecha_nacimiento", usuario.getFechaNacimiento())
                        .append("imagen_perfil", usuario.getImagenPerfil())
                        .append("direccion", usuario.getDireccion())
                        .append("sexo", usuario.getSexo())));
    }

    public DeleteResult eliminaUsuario(String telefono) {
        return collection.deleteOne(eq("telefono", telefono));
    }

    public Usuario encuentraUsuarioPorId(ObjectId id) {
        Document doc = collection.find(eq("_id", id)).first();
        return doc != null ? new Usuario(
                doc.getObjectId("_id"),
                doc.getString("telefono"),
                doc.getString("nombre"),
                doc.getString("contrasena_encriptada"),
                doc.getDate("fecha_nacimiento"),
                doc.get("imagen_perfil", Binary.class),
                doc.getString("direccion"),
                doc.getString("sexo")
        ) : null;
    }
}
