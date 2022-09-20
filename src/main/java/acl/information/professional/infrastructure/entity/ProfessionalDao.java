package acl.information.professional.infrastructure.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ProfessionalDao {
    @Id
    String professionalId;
    String nombre;
    String apellidos;
    String correo;
    List<String> nacionalidad;
    String paisResidencia;
    String comuna;
    String carreraTi;

}
