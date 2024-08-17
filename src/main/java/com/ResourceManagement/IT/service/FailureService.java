package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.dto.FailureDto;
import com.ResourceManagement.IT.mapper.FailureMapper;
import com.ResourceManagement.IT.model.Failure;
import com.ResourceManagement.IT.repository.FailureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FailureService {
    @Autowired
    private FailureRepository failureRepository;


    private final FailureMapper failureMapper = FailureMapper.INSTANCE;

    public Failure addFailure(FailureDto failureDto) {
        Failure failure = failureMapper.toFailureEntity(failureDto);
        Failure savedFailure = failureRepository.save(failure);
        return savedFailure;
    }

    public List<FailureDto> getAllFailure() {
        List<Failure> allFailure = failureRepository.findAll();
        return failureMapper.toFailureDtoList(allFailure);

    }
}
