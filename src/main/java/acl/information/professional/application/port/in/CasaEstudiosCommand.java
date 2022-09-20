package acl.information.professional.application.port.in;

import acl.information.professional.domain.model.CasaEstudios;

import java.util.List;

public interface CasaEstudiosCommand {

    List<CasaEstudios> getAllCasaEstudios();
    CasaEstudios getCasaEstudio(String id);
    void saveCasaEstudio(CasaEstudios person);
    void updateCasaEstudio(String id, CasaEstudios centro);
    void deleteCasaEstudio(String id);
}
