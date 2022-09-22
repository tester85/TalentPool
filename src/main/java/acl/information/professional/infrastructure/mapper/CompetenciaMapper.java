package acl.information.professional.infrastructure.mapper;

import acl.information.professional.domain.model.Competencia;
import acl.information.professional.infrastructure.entity.CompetenciaDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper {

    CompetenciaMapper INSTANCE = Mappers.getMapper(CompetenciaMapper.class);

    Competencia mapToCompetenciasModel(CompetenciaDao ability);

    CompetenciaDao mapToCompetenciasDao(Competencia ability);

    List<Competencia> mapToCompetenciasList(List<CompetenciaDao> ability);

}
