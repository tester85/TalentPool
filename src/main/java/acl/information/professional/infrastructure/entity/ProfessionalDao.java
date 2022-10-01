package acl.information.professional.infrastructure.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Builder
@Document
public class ProfessionalDao {
    @Id
    String professionalId;
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    String fechaNacimiento;
    List<String> nacionalidad;
    String paisResidencia;
    String ciudad;
    String comuna;
    String carreraTi;

    public ProfessionalDao(String professionalId, String nombre,String telefono, String apellidos, String correo, String fechaNacimiento, List<String> nacionalidad, String paisResidencia,String ciudad, String comuna, String carreraTi) {
        this.professionalId = professionalId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.paisResidencia = paisResidencia;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.carreraTi = carreraTi;
    }

    public ProfessionalDao() {
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<String> getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(List<String> nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCarreraTi() {
        return carreraTi;
    }

    public void setCarreraTi(String carreraTi) {
        this.carreraTi = carreraTi;
    }
}
