package acl.information.professional.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CasaEstudio {

    String professionalId;
    String semestre;
    Horario horario;
    String estado;
    Boolean esPractica;
}
