package interfaces;

import DTOs.Mensaje;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IMensajeDAO {
    void insertarMensaje(Mensaje mensaje);

    DeleteResult eliminarMensaje(ObjectId id);
}
