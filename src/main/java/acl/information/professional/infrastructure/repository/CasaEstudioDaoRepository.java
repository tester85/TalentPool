package acl.information.professional.infrastructure.repository;

import acl.information.professional.infrastructure.entity.CasaEstudiosDao;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaEstudioDaoRepository extends MongoRepository<CasaEstudiosDao, String> {
}

