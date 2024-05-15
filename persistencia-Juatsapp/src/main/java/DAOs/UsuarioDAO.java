package daos;

import DTOs.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

/**
 * 
 * @author eduar
 */
public class UsuarioDAO {
    private MongoCollection<Document> collection;

    public UsuarioDAO() {
        MongoDatabase database = persistencia.ConexionBD.getDatabase();
        collection = database.getCollection("usuario");
    }

    public void insertaUsuario(Usuario usuario) {
        Document doc = new Document("telefono", usuario.getTelefono())
                               .append("contrasena_encriptada", usuario.getContrasenaEncriptada())
                               .append("fecha_nacimiento", usuario.getFechaNacimiento())
                               .append("imagen_perfil", usuario.getImagenPerfil())
                               .append("direccion", usuario.getDireccion())
                               .append("sexo", usuario.getSexo());
        collection.insertOne(doc);
    }

    public Usuario encuentraUsuarioPorTelefono(String telefono) {
        Document doc = collection.find(eq("telefono", telefono)).first();
        return doc != null ? new Usuario(
            doc.getString("telefono"),
            doc.getString("contrasena_encriptada"),
            doc.getDate("fecha_nacimiento"),
            doc.getString("imagen_perfil"),
            doc.getString("direccion"),
            doc.getString("sexo")
        ) : null;
    }

    public UpdateResult actualizaUsuario(Usuario usuario) {
        return collection.updateOne(eq("telefono", usuario.getTelefono()),
            new Document("$set", new Document("contrasena_encriptada", usuario.getContrasenaEncriptada())
                                       .append("fecha_nacimiento", usuario.getFechaNacimiento())
                                       .append("imagen_perfil", usuario.getImagenPerfil())
                                       .append("direccion", usuario.getDireccion())
                                       .append("sexo", usuario.getSexo())));
    }

    public DeleteResult eliminaUsuario(String telefono) {
        return collection.deleteOne(eq("telefono", telefono));
    }
}
