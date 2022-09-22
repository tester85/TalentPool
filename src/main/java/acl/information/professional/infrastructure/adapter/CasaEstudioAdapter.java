package acl.information.professional.infrastructure.adapter;

import acl.information.professional.application.port.out.CasaEstudioRepository;
import acl.information.professional.domain.model.CasaEstudio;
import acl.information.professional.infrastructure.entity.CasaEstudioDao;
import acl.information.professional.infrastructure.mapper.CasaEstudioMapper;
import acl.information.professional.infrastructure.repository.CasaEstudioDaoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CasaEstudioAdapter implements CasaEstudioRepository {

    private final CasaEstudioDaoRepository  casaEstudioDaoRepository;

    public CasaEstudioAdapter(CasaEstudioDaoRepository casaEstudioDaoRepository) {
        this.casaEstudioDaoRepository = casaEstudioDaoRepository;
    }

    @Override
    public List<CasaEstudio> getAllCasaEstudios() {
        return CasaEstudioMapper.INSTANCE.mapToCasaEstudiosList(this.casaEstudioDaoRepository.findAll());
    }

    @Override
    public CasaEstudio getCasaEstudio(String id) {
        return this.casaEstudioDaoRepository.findById(id)
                .map(CasaEstudioMapper.INSTANCE::mapToCasaEstudiosModel)
                .orElseThrow((()-> new NoSuchElementException("Casa de estudios not found with id: "+id)));
    }

    @Override
    public void saveCasaEstudio(CasaEstudio centro) {
        CasaEstudioDao casaEstudioDao = CasaEstudioMapper.INSTANCE.mapToCasaEstudiosDao(centro);
        CasaEstudioDao casaEstudiosSaved = this.casaEstudioDaoRepository.save(casaEstudioDao);
        CasaEstudioMapper.INSTANCE.mapToCasaEstudiosModel(casaEstudiosSaved);
    }

    @Override
    public void updateCasaEstudio(CasaEstudio centro) {
        saveCasaEstudio(centro);
    }

    @Override
    public void deleteCasaEstudio(String id) {
        casaEstudioDaoRepository.deleteById(id);
    }
}

