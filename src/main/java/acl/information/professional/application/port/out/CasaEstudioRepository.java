package acl.information.professional.application.port.out;

import acl.information.professional.domain.model.CasaEstudio;

import java.util.List;

public interface CasaEstudioRepository {

    List<CasaEstudio> getAllCasaEstudios();
    CasaEstudio getCasaEstudio(String id);
    void saveCasaEstudio(CasaEstudio centro);
    void updateCasaEstudio(CasaEstudio centro);
    void deleteCasaEstudio(String id);
}
