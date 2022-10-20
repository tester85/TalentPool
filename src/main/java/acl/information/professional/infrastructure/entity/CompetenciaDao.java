package acl.information.professional.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Document
public class CompetenciaDao {
    @Id
    String professionalId;
    List<String> programingLanguages;
    List<String> frameworks;
    List<String> languages;
    List<String> dataBases;

    public CompetenciaDao() {    }

    public CompetenciaDao(String professionalId, List<String> programingLanguages, List<String> frameworks, List<String> languages, List<String> dataBases) {
        this.professionalId = professionalId;
        this.programingLanguages = programingLanguages;
        this.frameworks = frameworks;
        this.languages = languages;
        this.dataBases = dataBases;
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public List<String> getProgramingLanguages() {
        return programingLanguages;
    }

    public void setProgramingLanguages(List<String> programingLanguages) {
        this.programingLanguages = programingLanguages;
    }

    public List<String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(List<String> frameworks) {
        this.frameworks = frameworks;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getDataBases() {
        return dataBases;
    }

    public void setDataBases(List<String> dataBases) {
        this.dataBases = dataBases;
    }
}
