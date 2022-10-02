package acl.information.professional.infrastructure.mapper;


import acl.information.professional.domain.model.Horario;
import acl.information.professional.infrastructure.entity.CasaEstudioDao;
import acl.information.professional.infrastructure.entity.CompetenciaDao;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import acl.information.professional.infrastructure.model.PerfilDto;
import org.springframework.stereotype.Component;

@Component
public class PerfilDtoMapper {

    public ProfessionalDao mapToProfessionalDao(PerfilDto perfil) {
        return new ProfessionalDao(
                perfil.getTelefono(),
                perfil.getNombre(),
                perfil.getTelefono(),
                perfil.getApellidos(),
                perfil.getCorreo(),
                perfil.getFechaNacimiento(),
                perfil.getNacionalidad(),
                perfil.getPaisResidencia(),
                perfil.getCiudad(),
                perfil.getComuna(),
                perfil.getCarreraTi()
        );
    }

    public CasaEstudioDao mapToCasaEstudioDao(PerfilDto perfil) {
        return new CasaEstudioDao(
                perfil.getTelefono(),
                perfil.getSemestre(),
                Horario.valueOf(perfil.getHorario()),
                perfil.getUniversidad(),
                perfil.getFechaEgreso(),
                perfil.getEstado(),
                perfil.getEsPractica()
        );
    }

    public CompetenciaDao mapToCompetenciaDao(PerfilDto perfil) {
        return new CompetenciaDao(
                perfil.getTelefono(),
                perfil.getLenguajesProgramacion(),
                perfil.getFrameworks(),
                perfil.getIdiomas(),
                perfil.getBasesDatos()
        );
    }

}
