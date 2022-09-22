package acl.information.professional.application.port.in;

import acl.information.professional.domain.model.Competencias;

import java.util.List;

public interface CompetenciasCommand {
    List<Competencias> getAllSkills();
    Competencias getSkill(String id);
    void saveSkill(Competencias hability);
    void updateSkill(String id, Competencias hability);
    void deleteSkill(String id);
}
