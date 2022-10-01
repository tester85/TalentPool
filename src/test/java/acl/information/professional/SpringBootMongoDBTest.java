package acl.information.professional;
 
import acl.information.professional.domain.model.Professional;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import acl.information.professional.infrastructure.mapper.ProfessionalMapper;
import acl.information.professional.infrastructure.repository.ProfessionalDaoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.text.SimpleDateFormat;
import java.util.List;

@DataMongoTest
public class SpringBootMongoDBTest {

    private final ProfessionalDaoRepository professionalDaoRepository;
    private final ProfessionalMapper professionalMapper;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public SpringBootMongoDBTest(ProfessionalDaoRepository professionalDaoRepository, ProfessionalMapper professionalMapper) {
        this.professionalDaoRepository = professionalDaoRepository;
        this.professionalMapper = professionalMapper;
    }

    @BeforeAll
    public void setUp() throws Exception{
        ProfessionalDao person = new ProfessionalDao(
                "23","nombre","Apellido","email","123 34 1234","", List.of("Cuba","Canada"),"Cuba","","","devops"
        );
        professionalDaoRepository.save(person);
    }

    @Test
    public void shouldBeNotEmpty() {
        assert(!((professionalDaoRepository.findAll()).isEmpty()));
    }

}
