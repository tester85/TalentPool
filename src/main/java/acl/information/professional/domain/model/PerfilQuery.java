package acl.information.professional.domain.model;

import lombok.Value;

import java.util.List;

@Value
public class PerfilQuery {

    String professionalId;
    String nombre;
    String apellidos;
    String correo;
    List<String> nacionalidad;
    String paisResidencia;
    String comuna;
    String carreraTi;
//    casa de estudios
    String semestre;
    Horario horario;
    String estado;
    Boolean esPractica;
//    Competencias
    List<String> lenguajesProgramacion;
    List<String> frameworks;
    List<String> idiomas;
    List<String> basesDatos;
}
