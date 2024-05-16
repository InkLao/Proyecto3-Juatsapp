package control;

import DTOs.Usuario;
import daos.UsuarioDAO;
import java.util.Date;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author eduar
 */
public class ControlUsuario {
    private UsuarioDAO usuarioDAO;

    public ControlUsuario() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void registrarUsuario(String telefono, String nombre, String contrasena, String direccion, String sexo, Date fechaNacimiento, Binary imagenPerfil) {
        String contrasenaEncriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
        Usuario usuario = new Usuario(telefono, nombre, contrasenaEncriptada, fechaNacimiento, imagenPerfil, direccion, sexo);
        try {
            usuarioDAO.insertarUsuario(usuario);
            System.out.println("Usuario registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al registrar usuario.");
        }
    }

    public Usuario obtenerUsuarioPorTelefono(String telefono) {
        try {
            return usuarioDAO.encuentraUsuarioPorTelefono(telefono);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener usuario por teléfono.");
            return null;
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        if (usuario.getContrasenaEncriptada() != null && !usuario.getContrasenaEncriptada().isEmpty()) {
            String contrasenaEncriptada = BCrypt.hashpw(usuario.getContrasenaEncriptada(), BCrypt.gensalt());
            usuario.setContrasenaEncriptada(contrasenaEncriptada);
        }
        try {
            usuarioDAO.actualizarUsuario(usuario);
            System.out.println("Usuario actualizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al actualizar usuario.");
        }
    }
    
    public Usuario obtenerUsuarioPorId(ObjectId id) {
    try {
        return usuarioDAO.encuentraUsuarioPorId(id);
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al obtener usuario por ID.");
        return null;
    }
}

}
