package acl.information.professional.application.port.out;

import acl.information.professional.domain.model.Competencia;

import java.util.List;

public interface CompetenciaRepository {

    List<Competencia> getAllCompetencia();
    Competencia getCompetencia(String id);
    void saveCompetencia(Competencia ability);
    void updateCompetencia(Competencia ability);
    void deleteCompetencia(String id);
}
