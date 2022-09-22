package acl.information.professional.infrastructure.repository;

import acl.information.professional.infrastructure.entity.CasaEstudiosDao;
import acl.information.professional.infrastructure.entity.CompetenciasDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciasDaoRepository extends MongoRepository<CompetenciasDao, String> {
}

