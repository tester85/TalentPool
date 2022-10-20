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
    String semester;
    Horario schedule;
    String university;
    String egressDate;
    String state;
    Boolean isProfessionalPractice;

    public CasaEstudioDao() {}

    public CasaEstudioDao(String professionalId, String semester, Horario schedule, String university, String egressDate, String state, Boolean isProfessionalPractice) {
        this.professionalId = professionalId;
        this.semester = semester;
        this.schedule = schedule;
        this.university = university;
        this.egressDate = egressDate;
        this.state = state;
        this.isProfessionalPractice = isProfessionalPractice;
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Horario getSchedule() {
        return schedule;
    }

    public void setSchedule(Horario schedule) {
        this.schedule = schedule;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getEgressDate() {
        return egressDate;
    }

    public void setEgressDate(String egressDate) {
        this.egressDate = egressDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getIsProfessionalPractice() {
        return isProfessionalPractice;
    }

    public void setIsProfessionalPractice(Boolean isProfessionalPractice) {
        this.isProfessionalPractice = isProfessionalPractice;
    }
}
