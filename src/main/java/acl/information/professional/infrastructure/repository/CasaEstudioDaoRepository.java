package acl.information.professional.infrastructure.repository;

import acl.information.professional.infrastructure.entity.CasaEstudioDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaEstudioDaoRepository extends MongoRepository<CasaEstudioDao, String> {
}

