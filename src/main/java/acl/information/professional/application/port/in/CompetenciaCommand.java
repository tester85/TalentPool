package acl.information.professional.application.port.in;

import acl.information.professional.domain.model.Competencia;

import java.util.List;

public interface CompetenciaCommand {

    List<Competencia> getAllCompetencia();
    Competencia getCompetencia(String id);
    void saveCompetencia(Competencia habilidad);
    void updateCompetencia(String id, Competencia habilidad);
    void deleteCompetencia(String id);
}
