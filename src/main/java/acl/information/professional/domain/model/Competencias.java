package acl.information.professional.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Competencias {

    String professionalId;
    List<String> lenguajesProgramacion;
    List<String> frameworks;
    List<String> idiomas;
    List<String> basesDatos;

}
