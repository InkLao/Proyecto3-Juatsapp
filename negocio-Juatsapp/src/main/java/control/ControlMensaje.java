package control;

import DTOs.Mensaje;
import daos.MensajeDAO;
import org.bson.types.ObjectId;
import java.util.List;

/**
 *
 * @author eduar
 */
public class ControlMensaje {
    private MensajeDAO mensajeDAO;

    public ControlMensaje() {
        this.mensajeDAO = new MensajeDAO();
    }

    public void enviarMensaje(ObjectId chatId, ObjectId usuarioId, String textoMensaje, String imagen) {
        Mensaje mensaje = new Mensaje();
        mensaje.setChatId(chatId);
        mensaje.setUsuarioId(usuarioId);
        mensaje.setTextoMensaje(textoMensaje);
        mensaje.setImagen(imagen);
        try {
            mensajeDAO.insertarMensaje(mensaje);
            System.out.println("Mensaje enviado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al enviar mensaje.");
        }
    }

//    public List<Mensaje> obtenerMensajesPorChatId(ObjectId chatId) {
//        return mensajeDAO.obtenerMensajesPorChatId(chatId);
//    }
    
    public List<Mensaje> obtenerMensajesChat(ObjectId chatId) {
        return mensajeDAO.obtenerMensajesPorChatId(chatId);
    }
}
