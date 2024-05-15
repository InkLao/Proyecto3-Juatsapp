/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.Usuario;
import daos.UsuarioDAO;

/**
 *
 * @author eduar
 */
public class ControlUsuario {
    private UsuarioDAO usuarioDAO;

    public ControlUsuario() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void registrarUsuario(String telefono, String nombre, String contrasenaEncriptada, String imagenPerfil, String direccion, String sexo) {
        Usuario usuario = new Usuario();
        usuario.setTelefono(telefono);
        usuario.setNombre(nombre);
        usuario.setContrasenaEncriptada(contrasenaEncriptada);
        usuario.setImagenPerfil(imagenPerfil);
        usuario.setDireccion(direccion);
        usuario.setSexo(sexo);
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
        try {
            usuarioDAO.actualizarUsuario(usuario);
            System.out.println("Usuario actualizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al actualizar usuario.");
        }
    }
}
