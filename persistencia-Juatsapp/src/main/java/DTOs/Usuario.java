package DTOs;

import org.bson.types.Binary;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 *
 * @author eduar
 */
public class Usuario {
    private ObjectId id;
    private String telefono;
    private String contrasenaEncriptada;
    private Date fechaNacimiento;
    private Binary imagenPerfil; // Cambiado a Binary
    private String direccion;
    private String sexo;
    private String nombre;

    public Usuario(String telefono, String nombre, String contrasenaEncriptada, Date fechaNacimiento, Binary imagenPerfil, String direccion, String sexo) {
        this.telefono = telefono;
        this.contrasenaEncriptada = contrasenaEncriptada;
        this.fechaNacimiento = fechaNacimiento;
        this.imagenPerfil = imagenPerfil;
        this.direccion = direccion;
        this.sexo = sexo;
        this.nombre = nombre;
    }

    public Usuario() {

    }

    // Getters y setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenaEncriptada() {
        return contrasenaEncriptada;
    }

    public void setContrasenaEncriptada(String contrasenaEncriptada) {
        this.contrasenaEncriptada = contrasenaEncriptada;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Binary getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(Binary imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
