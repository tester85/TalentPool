package acl.information.professional.application.port.out;

import acl.information.professional.domain.model.CasaEstudio;

import java.util.List;

public interface CasaEstudioRepository {

    List<CasaEstudio> getAllCasaEstudios();
    CasaEstudio getCasaEstudio(String id);
    void saveCasaEstudio(CasaEstudio school);
    void updateCasaEstudio(CasaEstudio school);
    void deleteCasaEstudio(String id);
}
