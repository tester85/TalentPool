package acl.information.professional.domain.model;


import java.util.Date;


public class CasaEstudio {

    String professionalId;
    String semestre;
    Horario horario;
    String universidad;
    String fechaEgreso;
    String estado;
    Boolean esPractica;

    public CasaEstudio() {
    }

    public CasaEstudio(String professionalId, String semestre, Horario horario, String estado, String universidad, String fechaEgreso, Boolean esPractica) {
        this.professionalId = professionalId;
        this.semestre = semestre;
        this.universidad = universidad;
        this.fechaEgreso = fechaEgreso;
        this.horario = horario;
        this.estado = estado;
        this.esPractica = esPractica;
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

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
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
