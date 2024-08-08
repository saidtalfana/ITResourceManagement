package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.enums.Roles;
import com.ResourceManagement.IT.model.Technician;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.EquipmentRepository;
import com.ResourceManagement.IT.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TechnicianService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private TechnicianRepository technicianRepository;

    public Technician addTechnician(Technician technician) {
        technician.setPassword(passwordEncoder.encode(technician.getPassword()));
        Set<Roles> role = new HashSet<Roles>();
        role.add(Roles.TECHNICIAN);
        technician.setRoles(role);
        return technicianRepository.save(technician);
    }



    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }
    public void deleteTechnician(Long id) {
         technicianRepository.deleteById(id);
    }
}
