package DTOs;

import java.util.List;

/**
 * 
 * @author eduar
 */
public class Chat {
    private String id;
    private String nombreChat;
    private String imagenMiniatura;
    private List<String> participantes; // Lista de IDs de usuarios

    public Chat(String id, String nombreChat, String imagenMiniatura, List<String> participantes) {
        this.id = id;
        this.nombreChat = nombreChat;
        this.imagenMiniatura = imagenMiniatura;
        this.participantes = participantes;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreChat() {
        return nombreChat;
    }

    public void setNombreChat(String nombreChat) {
        this.nombreChat = nombreChat;
    }

    public String getImagenMiniatura() {
        return imagenMiniatura;
    }

    public void setImagenMiniatura(String imagenMiniatura) {
        this.imagenMiniatura = imagenMiniatura;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }
}
