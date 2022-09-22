package acl.information.professional.infrastructure.mapper;

import acl.information.professional.domain.model.CasaEstudios;
import acl.information.professional.domain.model.Competencias;
import acl.information.professional.infrastructure.entity.CasaEstudiosDao;
import acl.information.professional.infrastructure.entity.CompetenciasDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciasMapper {

    CompetenciasMapper INSTANCE = Mappers.getMapper(CompetenciasMapper.class);

    Competencias mapToCompetenciasModel(CompetenciasDao hability);

    CompetenciasDao mapToCompetenciasDao(Competencias hability);

    List<Competencias> mapToCompetenciasList(List<CompetenciasDao> hability);

    Object mapToCompetencias(Object o);
}
