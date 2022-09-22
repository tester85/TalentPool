package acl.information.professional.infrastructure.adapter;

import acl.information.professional.application.port.out.CompetenciasRepository;
import acl.information.professional.domain.model.Competencias;
import acl.information.professional.infrastructure.entity.CompetenciasDao;
import acl.information.professional.infrastructure.mapper.CompetenciasMapper;
import acl.information.professional.infrastructure.repository.CompetenciasDaoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CompetenciasAdapter implements CompetenciasRepository {

    private final CompetenciasDaoRepository competenciasDaoRepository;

    public CompetenciasAdapter(CompetenciasDaoRepository competenciasDaoRepository) {
        this.competenciasDaoRepository = competenciasDaoRepository;
    }

    @Override
    public List<Competencias> getAllSkills() {
        return CompetenciasMapper.INSTANCE.mapToCompetenciasList(competenciasDaoRepository.findAll());
    }

    @Override
    public Competencias getSkill(String id) {
       return competenciasDaoRepository.findById(id).
               map(CompetenciasMapper.INSTANCE::mapToCompetenciasModel)
               .orElseThrow((()-> new NoSuchElementException("No hay habilidades registradas para el profesional: "+ id)));
    }

    @Override
    public void saveSkill(Competencias hability) {
        CompetenciasDao skill = CompetenciasMapper.INSTANCE.mapToCompetenciasDao(hability);
        CompetenciasDao skillSaved = competenciasDaoRepository.save(skill);
        CompetenciasMapper.INSTANCE.mapToCompetenciasModel(skillSaved);
    }

    @Override
    public void updateSkill(Competencias hability) {
        saveSkill(hability);
    }

    @Override
    public void deleteSkill(String id) {
        CompetenciasDao skill = CompetenciasMapper.INSTANCE.mapToCompetenciasDao(getSkill(id));
        if(skill == null){
            throw new NoSuchElementException("No hay registros para el profesional: "+ id);
        }
        competenciasDaoRepository.deleteById(id);
    }
}
