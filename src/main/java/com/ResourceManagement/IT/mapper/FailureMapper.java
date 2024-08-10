package com.ResourceManagement.IT.mapper;


import com.ResourceManagement.IT.dto.FailureDto;
import com.ResourceManagement.IT.model.Failure;
import org.mapstruct.Mapper;

@Mapper()
public interface FailureMapper {

    Failure toFailureDto(FailureDto failureDto);

    FailureDto toFailureEntity(Failure failure);



}
