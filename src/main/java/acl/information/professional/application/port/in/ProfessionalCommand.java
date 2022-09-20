package acl.information.professional.application.port.in;

import acl.information.professional.domain.model.Professional;

import java.util.List;

public interface ProfessionalCommand {

    List<Professional> getAllProfessionals();
    Professional getProfessional(String id);
    void saveProfessional(Professional person);
    void updateProfessional(String id, Professional person);
    void deleteProfessional(String id);
}
