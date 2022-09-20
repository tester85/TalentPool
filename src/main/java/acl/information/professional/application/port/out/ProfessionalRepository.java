package acl.information.professional.application.port.out;

import acl.information.professional.domain.model.Professional;

import java.util.List;

public interface ProfessionalRepository {

    List<Professional> getAllProfessionals();
    Professional getProfessional(String id);
    void saveProfessional(Professional person);
    void updateProfessional(Professional person);
    void deleteProfessional(String id);
}
