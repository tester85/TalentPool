package acl.information.professional.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CasaEstudios {

    String professionalId;
    String semestre;
    Horario horario;
    String estado;
    Boolean esPractica;
}
