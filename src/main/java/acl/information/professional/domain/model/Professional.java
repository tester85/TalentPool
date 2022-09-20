package acl.information.professional.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professional {

    String professionalId;
    String nombre;
    String apellidos;
    String correo;
    List<String> nacionalidad;
    String paisResidencia;
    String comuna;
    String carreraTi;

}
