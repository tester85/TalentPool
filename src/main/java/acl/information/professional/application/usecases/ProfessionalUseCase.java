package acl.information.professional.application.usecases;

import acl.information.professional.application.port.in.ProfessionalCommand;
import acl.information.professional.application.port.out.ProfessionalRepository;
import acl.information.professional.domain.model.Professional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
class ProfessionalUseCase implements ProfessionalCommand {

    private final ProfessionalRepository professionalRepository;

    ProfessionalUseCase(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }


    @Override
    public List<Professional> getAllProfessionals() {
        return professionalRepository.getAllProfessionals();
    }

    @Override
    public Professional getProfessional(String id) {
        Professional result = professionalRepository.getProfessional(id);
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }


    @Override
    public void saveProfessional(Professional person) {
        professionalRepository.saveProfessional(person);

    }
    @Override
    public void updateProfessional(String id, Professional person) {
        if (!id.equals(getProfessional(id)))
            throw new NoSuchElementException();
        getProfessional(id);
        professionalRepository.updateProfessional(person);
    }

    @Override
    public void deleteProfessional(String id) {
        professionalRepository.deleteProfessional(id);

    }
}
