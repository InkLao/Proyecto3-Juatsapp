package interfaces;

import DTOs.Usuario;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IUsuarioDAO {
    void insertarUsuario(Usuario usuario);
    Usuario encuentraUsuarioPorTelefono(String telefono);
    UpdateResult actualizarUsuario(Usuario usuario);
}
