package acl.information.professional.application.usecases;

import acl.information.professional.application.port.in.CasaEstudiosCommand;
import acl.information.professional.application.port.out.CasaEstudioRepository;
import acl.information.professional.domain.model.CasaEstudio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

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
        CasaEstudio result = casaEstudioRepository.getCasaEstudio(id);
        if(result == null){
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public void saveCasaEstudio(CasaEstudio centro) {
        casaEstudioRepository.saveCasaEstudio(centro);
    }

    @Override
    public void updateCasaEstudio(String id, CasaEstudio centro) {
        if (!id.equals(getCasaEstudio(id)))
            throw new NoSuchElementException();
        getCasaEstudio(id);
        casaEstudioRepository.updateCasaEstudio(centro);
    }

    @Override
    public void deleteCasaEstudio(String id) {
        CasaEstudio result = casaEstudioRepository.getCasaEstudio(id);
        if(result == null){
            throw new NoSuchElementException();
        }
        casaEstudioRepository.deleteCasaEstudio(id);
    }
}
