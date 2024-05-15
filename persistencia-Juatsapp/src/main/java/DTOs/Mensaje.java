package DTOs;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * 
 * @author eduar
 */
public class Mensaje {
    private ObjectId id;
    private ObjectId chatId;
    private ObjectId usuarioId;
    private String textoMensaje;
    private Date fechaHora;
    private String imagen;

    public Mensaje(ObjectId id, ObjectId chatId, ObjectId usuarioId, String textoMensaje, Date fechaHora, String imagen) {
        this.id = id;
        this.chatId = chatId;
        this.usuarioId = usuarioId;
        this.textoMensaje = textoMensaje;
        this.fechaHora = fechaHora;
        this.imagen = imagen;
    }
    
    public Mensaje(ObjectId chatId, ObjectId usuarioId, String textoMensaje, Date fechaHora, String imagen) {
    this.chatId = chatId;
    this.usuarioId = usuarioId;
    this.textoMensaje = textoMensaje;
    this.fechaHora = fechaHora; // Asegúrate de tener este campo correctamente tipado si decides usarlo
    this.imagen = imagen;
}


    public Mensaje() {
        
    }
    
    // Getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getChatId() {
        return chatId;
    }

    public void setChatId(ObjectId chatId) {
        this.chatId = chatId;
    }

    public ObjectId getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(ObjectId usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTextoMensaje() {
        return textoMensaje;
    }

    public void setTextoMensaje(String textoMensaje) {
        this.textoMensaje = textoMensaje;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
