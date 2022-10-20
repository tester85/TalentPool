package acl.information.professional.application.port.in;

import acl.information.professional.domain.model.CasaEstudio;

import java.util.List;

public interface CasaEstudiosCommand {

    List<CasaEstudio> getAllCasaEstudios();
    CasaEstudio getCasaEstudio(String id);
    void saveCasaEstudio(CasaEstudio school);
    void updateCasaEstudio(String id, CasaEstudio school);
    void deleteCasaEstudio(String id);
}
