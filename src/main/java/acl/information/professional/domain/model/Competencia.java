package acl.information.professional.domain.model;

import java.util.List;

public class Competencia {

    String professionalId;
    List<String> lenguajesProgramacion;
    List<String> frameworks;
    List<String> idiomas;
    List<String> basesDatos;

    public Competencia(String professionalId, List<String> lenguajesProgramacion, List<String> frameworks, List<String> idiomas, List<String> basesDatos) {
        this.professionalId = professionalId;
        this.lenguajesProgramacion = lenguajesProgramacion;
        this.frameworks = frameworks;
        this.idiomas = idiomas;
        this.basesDatos = basesDatos;
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public List<String> getLenguajesProgramacion() {
        return lenguajesProgramacion;
    }

    public void setLenguajesProgramacion(List<String> lenguajesProgramacion) {
        this.lenguajesProgramacion = lenguajesProgramacion;
    }

    public List<String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(List<String> frameworks) {
        this.frameworks = frameworks;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public List<String> getBasesDatos() {
        return basesDatos;
    }

    public void setBasesDatos(List<String> basesDatos) {
        this.basesDatos = basesDatos;
    }
}
