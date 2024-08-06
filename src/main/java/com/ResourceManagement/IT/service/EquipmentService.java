package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.repository.AdminRepository;
import com.ResourceManagement.IT.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;
}
