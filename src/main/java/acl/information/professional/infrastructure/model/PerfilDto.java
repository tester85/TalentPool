package acl.information.professional.infrastructure.model;

import acl.information.professional.domain.model.Horario;

import java.util.List;


public class PerfilDto {
    String professionalId;
    String name;
    String lastName;
    String email;
    String phone;
    String birthDate;
    List<String> nationality;
    String residence;
    String city;
    String commune;
    String itCareer;
    //    casa de estudios
    String semester;
    Horario schedule;
    String university;
    String egressDate;
    String state;
    Boolean isProfessionalPractice;
    //    Competencias
    List<String> programingLanguages;
    List<String> frameworks;
    List<String> languages;
    List<String> dataBases;

    public PerfilDto(String professionalId, String name, String lastName, String email, String phone, String birthDate, List<String> nationality, String residence, String city, String commune, String itCareer, String semester, Horario schedule, String university, String egressDate, String state, Boolean isProfessionalPractice, List<String> programingLanguages, List<String> frameworks, List<String> languages, List<String> dataBases) {
        this.professionalId = professionalId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.residence = residence;
        this.city = city;
        this.commune = commune;
        this.itCareer = itCareer;
        this.semester = semester;
        this.schedule = schedule;
        this.university = university;
        this.egressDate = egressDate;
        this.state = state;
        this.isProfessionalPractice = isProfessionalPractice;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getNationality() {
        return nationality;
    }

    public void setNationality(List<String> nationality) {
        this.nationality = nationality;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getItCareer() {
        return itCareer;
    }

    public void setItCareer(String itCareer) {
        this.itCareer = itCareer;
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

