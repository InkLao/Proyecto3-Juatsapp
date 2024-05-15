package DTOs;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * 
 * @author eduar
 */
public class Usuario {
    private ObjectId id;
    private String telefono;
    private String contrasenaEncriptada;
    private Date fechaNacimiento;
    private String imagenPerfil;
    private String direccion;
    private String sexo;
    private String nombre;

    public Usuario(String telefono, String contrasenaEncriptada, Date fechaNacimiento, String imagenPerfil, String direccion, String sexo, String nombre) {
        this.telefono = telefono;
        this.contrasenaEncriptada = contrasenaEncriptada;
        this.fechaNacimiento = fechaNacimiento;
        this.imagenPerfil = imagenPerfil;
        this.direccion = direccion;
        this.sexo = sexo;
        this.nombre=nombre;
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

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
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
}
