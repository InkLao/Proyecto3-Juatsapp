/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
