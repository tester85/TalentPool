package acl.information.professional.infrastructure.adapter;

import acl.information.professional.application.port.out.ProfessionalRepository;
import acl.information.professional.domain.model.Professional;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import acl.information.professional.infrastructure.mapper.ProfessionalMapper;
import acl.information.professional.infrastructure.repository.ProfessionalDaoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component

public class ProfessionalAdapter implements ProfessionalRepository {

    private final ProfessionalDaoRepository personRepository;

    public ProfessionalAdapter(ProfessionalDaoRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Professional> getAllProfessionals() {
        return ProfessionalMapper.INSTANCE.mapToProfessionalList(
                this.personRepository.findAll());
    }

    @Override
    public Professional getProfessional(String id) {
        return this.personRepository.findById(id)
                .map(ProfessionalMapper.INSTANCE::mapToProfessionalModel)
                .orElseThrow((()-> new NoSuchElementException("Professional not found with id: "+id)));
    }

    @Override
    public void saveProfessional(Professional person) {
        ProfessionalDao personDao = ProfessionalMapper.INSTANCE.mapToProfessionalDao(person);
        ProfessionalDao personSaved = this.personRepository.save(personDao);
        ProfessionalMapper.INSTANCE.mapToProfessionalModel(personSaved);
    }

    @Override
    public void updateProfessional(Professional person) {
        saveProfessional(person);
    }

    @Override
    public void deleteProfessional(String id) {
        personRepository.deleteById(id);

    }

}
