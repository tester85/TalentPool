package acl.information.professional.application.port.out;

import acl.information.professional.domain.model.Competencias;

import java.util.List;

public interface CompetenciasRepository {

    List<Competencias> getAllSkills();
    Competencias getSkill(String id);
    void saveSkill(Competencias hability);
    void updateSkill(Competencias hability);
    void deleteSkill(String id);
}
