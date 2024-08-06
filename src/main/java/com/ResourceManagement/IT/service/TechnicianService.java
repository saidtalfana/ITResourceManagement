package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.repository.EquipmentRepository;
import com.ResourceManagement.IT.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository technicianRepository;
}
