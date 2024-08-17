package com.ResourceManagement.IT.mapper;


import com.ResourceManagement.IT.dto.FailureDto;
import com.ResourceManagement.IT.model.Failure;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface FailureMapper {

    FailureMapper INSTANCE = Mappers.getMapper(FailureMapper.class);

    Failure toFailureEntity(FailureDto failureDto);

    FailureDto toFailureDto(Failure failure);

    List<FailureDto> toFailureDtoList(List<Failure> failures);



}
