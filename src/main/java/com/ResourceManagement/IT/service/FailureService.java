package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.model.Failure;
import com.ResourceManagement.IT.repository.EquipmentRepository;
import com.ResourceManagement.IT.repository.FailureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FailureService {
    @Autowired
    private FailureRepository failureRepository;

    public Failure addFailure(Failure failure) {
        return failureRepository.save(failure);
    }

    public List<Failure> getAllFailures() {
        return failureRepository.findAll();
    }
}
