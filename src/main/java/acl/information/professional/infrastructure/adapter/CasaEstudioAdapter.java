package acl.information.professional.infrastructure.adapter;

import acl.information.professional.application.port.out.CasaEstudioRepository;
import acl.information.professional.domain.model.CasaEstudios;
import acl.information.professional.infrastructure.entity.CasaEstudiosDao;
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
    public List<CasaEstudios> getAllCasaEstudios() {
        return CasaEstudioMapper.INSTANCE.mapToCasaEstudiosList(this.casaEstudioDaoRepository.findAll());
    }

    @Override
    public CasaEstudios getCasaEstudio(String id) {
        return this.casaEstudioDaoRepository.findById(id)
                .map(CasaEstudioMapper.INSTANCE::mapToCasaEstudiosModel)
                .orElseThrow((()-> new NoSuchElementException("Casa de estudios not found with id: "+id)));
    }

    @Override
    public void saveCasaEstudio(CasaEstudios centro) {
        CasaEstudiosDao casaEstudiosDao = CasaEstudioMapper.INSTANCE.mapToCasaEstudiosDao(centro);
        CasaEstudiosDao casaEstudiosSaved = this.casaEstudioDaoRepository.save(casaEstudiosDao);
        CasaEstudioMapper.INSTANCE.mapToCasaEstudiosModel(casaEstudiosSaved);
    }

    @Override
    public void updateCasaEstudio(CasaEstudios centro) {
        saveCasaEstudio(centro);
    }

    @Override
    public void deleteCasaEstudio(String id) {
        casaEstudioDaoRepository.deleteById(id);
    }
}

