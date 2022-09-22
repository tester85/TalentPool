package acl.information.professional.application.usecases;

import acl.information.professional.application.port.in.CompetenciaCommand;
import acl.information.professional.application.port.out.CompetenciaRepository;
import acl.information.professional.domain.model.Competencia;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CompetenciaUseCase implements CompetenciaCommand {

    private final CompetenciaRepository competenciaRepository;

    public CompetenciaUseCase(CompetenciaRepository competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }

    @Override
    public List<Competencia> getAllCompetencia() {
        return competenciaRepository.getAllCompetencia();
    }

    @Override
    public Competencia getCompetencia(String id) {
        Competencia result =  competenciaRepository.getCompetencia(id);
        if(result == null){
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public void saveCompetencia(Competencia ability) {
        competenciaRepository.saveCompetencia(ability);

    }

    @Override
    public void updateCompetencia(String id, Competencia ability) {
        if (!id.equals(getCompetencia(id).toString()))
            throw new NoSuchElementException();
        getCompetencia(id);
        competenciaRepository.updateCompetencia(ability);
    }

    @Override
    public void deleteCompetencia(String id) {
        Competencia result =  competenciaRepository.getCompetencia(id);
        if(result == null){
            throw new NoSuchElementException();
        }
        competenciaRepository.deleteCompetencia(id);
    }
}
