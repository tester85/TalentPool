package acl.information.professional.infrastructure.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
public class ProfessionalDao {
    @Id
    String professionalId;
    String nombre;
    String apellidos;
    String correo;
    List<String> nacionalidad;
    String paisResidencia;
    String comuna;
    String carreraTi;

    public ProfessionalDao(String professionalId, String nombre, String apellidos, String correo, List<String> nacionalidad, String paisResidencia, String comuna, String carreraTi) {
        this.professionalId = professionalId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.paisResidencia = paisResidencia;
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
