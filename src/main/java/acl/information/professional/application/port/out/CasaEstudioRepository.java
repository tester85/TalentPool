package acl.information.professional.application.port.out;

import acl.information.professional.domain.model.CasaEstudios;

import java.util.List;

public interface CasaEstudioRepository {

    List<CasaEstudios> getAllCasaEstudios();
    CasaEstudios getCasaEstudio(String id);
    void saveCasaEstudio(CasaEstudios centro);
    void updateCasaEstudio(CasaEstudios centro);
    void deleteCasaEstudio(String id);
}
