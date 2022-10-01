package acl.information.professional.infrastructure.entity;

import acl.information.professional.domain.model.CasaEstudio;
import acl.information.professional.domain.model.Horario;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Document
public class CasaEstudioDao {
    @Id
    String professionalId;
    String semestre;
    Horario horario;
    String universidad;
    String fechaEgreso;
    String estado;
    Boolean esPractica;

    public CasaEstudioDao() {}

    public CasaEstudioDao(String professionalId, String semestre, Horario horario, String universidad, String fechaEgreso,String estado, Boolean esPractica) {
        this.professionalId = professionalId;
        this.semestre = semestre;
        this.universidad = universidad;
        this.fechaEgreso = fechaEgreso;
        this.horario = horario;
        this.estado = estado;
        this.esPractica = esPractica;
    }

    public String getUniversidad() {
        return universidad;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getEsPractica() {
        return esPractica;
    }

    public void setEsPractica(Boolean esPractica) {
        this.esPractica = esPractica;
    }
}
