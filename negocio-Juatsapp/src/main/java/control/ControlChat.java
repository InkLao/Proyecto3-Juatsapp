/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.Chat;
import daos.ChatDAO;
import java.util.List;

/**
 *
 * @author eduar
 */
public class ControlChat {
    private ChatDAO chatDAO;

    public ControlChat() {
        this.chatDAO = new ChatDAO();
    }

    public void crearChat(String nombreChat, String imagenMiniatura, List<String> participantes) {
        Chat chat = new Chat();
        chat.setNombreChat(nombreChat);
        chat.setImagenMiniatura(imagenMiniatura);
        chat.setParticipantes(participantes);
        try {
            chatDAO.insertarChat(chat);
            System.out.println("Chat creado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear el chat.");
        }
    }

    public Chat buscarChatPorNombre(String nombreChat) {
        try {
            return chatDAO.encontrarChatPorNombre(nombreChat);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar el chat por nombre.");
            return null;
        }
    }
}
