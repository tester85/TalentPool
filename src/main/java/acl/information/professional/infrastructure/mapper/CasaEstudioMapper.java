package acl.information.professional.infrastructure.mapper;

import acl.information.professional.domain.model.CasaEstudios;
import acl.information.professional.domain.model.Professional;
import acl.information.professional.infrastructure.entity.CasaEstudiosDao;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CasaEstudioMapper {

    CasaEstudioMapper INSTANCE = Mappers.getMapper(CasaEstudioMapper.class);

    CasaEstudios mapToCasaEstudiosModel(CasaEstudiosDao escuelas);

    CasaEstudiosDao mapToCasaEstudiosDao(CasaEstudios escuelas);

    List<CasaEstudios> mapToCasaEstudiosList(List<CasaEstudiosDao> escuelas);

    Object mapToCasaEstudios(Object o);
}
