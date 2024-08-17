package com.ResourceManagement.IT.mapper;


import ch.qos.logback.core.model.ComponentModel;
import com.ResourceManagement.IT.dto.TechnicianDto;
import com.ResourceManagement.IT.model.Technician;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface TechnicianMapper {

    TechnicianMapper INSTANCE = Mappers.getMapper(TechnicianMapper.class);

       Technician toTechnicianEntity(TechnicianDto technicianDto);

       TechnicianDto toTechnicianDto(Technician technician);
}
