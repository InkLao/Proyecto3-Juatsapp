package control;

import DTOs.Usuario;
import daos.UsuarioDAO;
import org.bson.types.Binary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author eduar
 */
public class ControlUsuario {
    private UsuarioDAO usuarioDAO;

    public ControlUsuario() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void registrarUsuario(String telefono, String nombre, String contrasenaEncriptada, String imagenPerfilPath, String direccion, String sexo, Date fechaNacimiento) {
        Usuario usuario = new Usuario();
        usuario.setTelefono(telefono);
        usuario.setNombre(nombre);
        usuario.setContrasenaEncriptada(contrasenaEncriptada);
        usuario.setDireccion(direccion);
        usuario.setSexo(sexo);
        usuario.setFechaNacimiento(fechaNacimiento);
        try {
            File imagenFile = new File(imagenPerfilPath);
            FileInputStream fis = new FileInputStream(imagenFile);
            byte[] imagenBytes = new byte[(int) imagenFile.length()];
            fis.read(imagenBytes);
            fis.close();
            usuario.setImagenPerfil(new Binary(imagenBytes));
            usuarioDAO.insertarUsuario(usuario);
            System.out.println("Usuario registrado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al registrar usuario: " + e.getMessage());
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
        try {
            usuarioDAO.actualizarUsuario(usuario);
            System.out.println("Usuario actualizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al actualizar usuario.");
        }
    }
}
