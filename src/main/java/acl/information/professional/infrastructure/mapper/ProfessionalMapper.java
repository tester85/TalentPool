package acl.information.professional.infrastructure.mapper;

import acl.information.professional.infrastructure.entity.ProfessionalDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import acl.information.professional.domain.model.Professional;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper {

    ProfessionalMapper INSTANCE = Mappers.getMapper(ProfessionalMapper.class);

    Professional mapToProfessionalModel(ProfessionalDao person);

    ProfessionalDao mapToProfessionalDao(Professional person);

    List<Professional> mapToProfessionalList(List<ProfessionalDao> personList);

    Object mapToProfessionalModel(Object o);
}
