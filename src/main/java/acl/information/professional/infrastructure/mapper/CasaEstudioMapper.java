package acl.information.professional.infrastructure.mapper;

import acl.information.professional.domain.model.CasaEstudio;
import acl.information.professional.infrastructure.entity.CasaEstudioDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CasaEstudioMapper {

    CasaEstudioMapper INSTANCE = Mappers.getMapper(CasaEstudioMapper.class);

    CasaEstudio mapToCasaEstudiosModel(CasaEstudioDao study);

    CasaEstudioDao mapToCasaEstudiosDao(CasaEstudio study);

    List<CasaEstudio> mapToCasaEstudiosList(List<CasaEstudioDao> study);
}
