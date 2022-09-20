package acl.information.professional.infrastructure.entity;

import acl.information.professional.domain.model.Horario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class CasaEstudiosDao {
    @Id
    Integer professionalId;
    String semestre;
    Horario horario;
    String estado;
    Boolean esPractica;
}
