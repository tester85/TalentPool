package acl.information.professional.infrastructure.repository;

import acl.information.professional.infrastructure.entity.ProfessionalDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalDaoRepository extends MongoRepository<ProfessionalDao, String> {
}

