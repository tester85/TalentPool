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
                perfil.getPhone(),
                perfil.getName(),
                perfil.getPhone(),
                perfil.getLastName(),
                perfil.getEmail(),
                perfil.getBirthDate(),
                perfil.getNationality(),
                perfil.getResidence(),
                perfil.getCity(),
                perfil.getCommune(),
                perfil.getItCareer()
        );
    }

    public CasaEstudioDao mapToCasaEstudioDao(PerfilDto perfil) {
        return new CasaEstudioDao(
                perfil.getPhone(),
                perfil.getSemester(),
                perfil.getSchedule(),
                perfil.getUniversity(),
                perfil.getEgressDate(),
                perfil.getState(),
                perfil.getIsProfessionalPractice()
        );
    }

    public CompetenciaDao mapToCompetenciaDao(PerfilDto perfil) {
        return new CompetenciaDao(
                perfil.getPhone(),
                perfil.getProgramingLanguages(),
                perfil.getFrameworks(),
                perfil.getLanguages(),
                perfil.getDataBases()
        );
    }

}
