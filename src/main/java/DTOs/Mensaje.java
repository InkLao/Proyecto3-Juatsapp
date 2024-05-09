package DTOs;

import java.util.Date;

/**
 * 
 * @author eduar
 */
public class Mensaje {
    private String id;
    private String chatId;
    private String usuarioId;
    private String textoMensaje;
    private Date fechaHora;
    private String imagen;

    public Mensaje(String id, String chatId, String usuarioId, String textoMensaje, Date fechaHora, String imagen) {
        this.id = id;
        this.chatId = chatId;
        this.usuarioId = usuarioId;
        this.textoMensaje = textoMensaje;
        this.fechaHora = fechaHora;
        this.imagen = imagen;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
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
