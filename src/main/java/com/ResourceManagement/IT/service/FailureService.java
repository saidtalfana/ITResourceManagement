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

    public FailureDto addFailure(FailureDto failureDto) {
        Failure failure = failureMapper.toFailureEntity(failureDto);
        Failure savedFailure = failureRepository.save(failure);
        return failureMapper.toFailureDto(savedFailure);

    }

    public List<Failure> getAllFailure() {
        return failureRepository.findAll();
    }
}
