/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.Chat;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IChatDAO {
    void insertarChat(Chat chat);

    Chat encontrarChatPorNombre(String nombreChat);

    UpdateResult actualizarChat(Chat chat);

    DeleteResult eliminarChat(ObjectId id);
}
