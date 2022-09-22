package acl.information.professional.infrastructure.adapter;

import acl.information.professional.application.port.out.CompetenciaRepository;
import acl.information.professional.domain.model.Competencia;
import acl.information.professional.infrastructure.entity.CompetenciaDao;
import acl.information.professional.infrastructure.mapper.CompetenciaMapper;
import acl.information.professional.infrastructure.repository.CompetenciaDaoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CompetenciaAdapter implements CompetenciaRepository {

    private final CompetenciaDaoRepository competenciaDaoRepository;

    public CompetenciaAdapter(CompetenciaDaoRepository competenciaDaoRepository) {
        this.competenciaDaoRepository = competenciaDaoRepository;
    }

    @Override
    public List<Competencia> getAllCompetencia() {
        return CompetenciaMapper.INSTANCE.mapToCompetenciasList(competenciaDaoRepository.findAll());
    }

    @Override
    public Competencia getCompetencia(String id) {
       return competenciaDaoRepository.findById(id).
               map(CompetenciaMapper.INSTANCE::mapToCompetenciasModel)
               .orElseThrow((()-> new NoSuchElementException("No hay habilidades registradas para el profesional: "+ id)));
    }

    @Override
    public void saveCompetencia(Competencia ability) {
        CompetenciaDao skill = CompetenciaMapper.INSTANCE.mapToCompetenciasDao(ability);
        CompetenciaDao skillSaved = competenciaDaoRepository.save(skill);
        CompetenciaMapper.INSTANCE.mapToCompetenciasModel(skillSaved);
    }

    @Override
    public void updateCompetencia(Competencia ability) {
        saveCompetencia(ability);
    }

    @Override
    public void deleteCompetencia(String id) {
        CompetenciaDao skill = CompetenciaMapper.INSTANCE.mapToCompetenciasDao(getCompetencia(id));
        if(skill == null){
            throw new NoSuchElementException("No hay registros para el profesional: "+ id);
        }
        competenciaDaoRepository.deleteById(id);
    }
}
