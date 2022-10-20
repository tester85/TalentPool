package acl.information.professional.domain.model;

import java.util.Date;
import java.util.List;


public class Professional {

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

    public Professional() {
    }

    public Professional(String professionalId, String name, String lastName, String email, String phone, String birthDate, List<String> nationality, String residence, String city, String commune, String itCareer) {
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
}
