package acl.information.professional.infrastructure.repository;

import acl.information.professional.infrastructure.entity.CompetenciaDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaDaoRepository extends MongoRepository<CompetenciaDao, String> {
}

