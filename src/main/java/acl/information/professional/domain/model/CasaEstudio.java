package acl.information.professional.domain.model;


import java.util.Date;


public class CasaEstudio {

    String professionalId;
    String semester;
    Horario schedule;
    String university;
    String egressDate;
    String state;
    Boolean isProfessionalPractice;

    public CasaEstudio() {
    }

    public CasaEstudio(String professionalId, String semester, Horario schedule, String university, String egressDate, String state, Boolean isProfessionalPractice) {
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
