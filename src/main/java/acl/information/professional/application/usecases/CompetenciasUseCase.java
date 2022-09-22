package acl.information.professional.application.usecases;

import acl.information.professional.application.port.in.CompetenciasCommand;
import acl.information.professional.application.port.out.CompetenciasRepository;
import acl.information.professional.domain.model.Competencias;

import java.util.List;
import java.util.NoSuchElementException;

public class CompetenciasUseCase implements CompetenciasCommand {

    private final CompetenciasRepository competenciasRepository;

    public CompetenciasUseCase(CompetenciasRepository competenciasRepository) {
        this.competenciasRepository = competenciasRepository;
    }

    @Override
    public List<Competencias> getAllSkills() {
        return competenciasRepository.getAllSkills();
    }

    @Override
    public Competencias getSkill(String id) {
        Competencias result =  competenciasRepository.getSkill(id);
        if(result == null){
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public void saveSkill(Competencias hability) {
        competenciasRepository.saveSkill(hability);

    }

    @Override
    public void updateSkill(String id, Competencias hability) {
        if (!id.equals(getSkill(id)))
            throw new NoSuchElementException();
        getSkill(id);
        competenciasRepository.updateSkill(hability);
    }

    @Override
    public void deleteSkill(String id) {
        Competencias result =  competenciasRepository.getSkill(id);
        if(result == null){
            throw new NoSuchElementException();
        }
        competenciasRepository.deleteSkill(id);
    }
}
