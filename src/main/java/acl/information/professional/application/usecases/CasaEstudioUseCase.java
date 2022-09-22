package acl.information.professional.application.usecases;

import acl.information.professional.application.port.in.CasaEstudiosCommand;
import acl.information.professional.application.port.out.CasaEstudioRepository;
import acl.information.professional.domain.model.CasaEstudio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CasaEstudioUseCase implements CasaEstudiosCommand {


    private final CasaEstudioRepository casaEstudioRepository;

    public CasaEstudioUseCase(CasaEstudioRepository casaEstudioRepository) {
        this.casaEstudioRepository = casaEstudioRepository;
    }

    @Override
    public List<CasaEstudio> getAllCasaEstudios() {
        return casaEstudioRepository.getAllCasaEstudios();
    }

    @Override
    public CasaEstudio getCasaEstudio(String id) {
        return null;
    }

    @Override
    public void saveCasaEstudio(CasaEstudio person) {

    }

    @Override
    public void updateCasaEstudio(String id, CasaEstudio centro) {

    }

    @Override
    public void deleteCasaEstudio(String id) {

    }
//
//    private final CasaEstudioRepository casaEstudioRepository;
//
//    public CasaEstudioUseCase(CasaEstudioRepository casaEstudioRepository) {
//        this.casaEstudioRepository = casaEstudioRepository;
//    }
//
//
//    @Override
//    public List<CasaEstudios> getAllCasaEstudios() {
//        return casaEstudioRepository.getAllCasaEstudios();
//    }
//
//    @Override
//    public CasaEstudios getCasaEstudio(String id) {
//        CasaEstudios result = casaEstudioRepository.getCasaEstudio(id);
//        if (result == null)
//            throw new NoSuchElementException();
//        return result;
//    }
//
//    @Override
//    public void saveCasaEstudio(CasaEstudios centro) {
//        casaEstudioRepository.saveCasaEstudio(centro);
//
//    }
//
//    @Override
//    public void updateCasaEstudio(String id, CasaEstudios centro) {
//        if (!id.equals(getCasaEstudio(id)))
//            throw new NoSuchElementException();
//        getCasaEstudio(id);
//        casaEstudioRepository.updateCasaEstudio(centro);
//
//    }
//
//    @Override
//    public void deleteCasaEstudio(String id) {
//        casaEstudioRepository.deleteCasaEstudio(id);
//
//    }
}
