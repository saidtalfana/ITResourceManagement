package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.model.Equipment;
import com.ResourceManagement.IT.repository.AdminRepository;
import com.ResourceManagement.IT.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }
    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentRepository.findById(id);
    }

    public void deleteEquipmentById(Long id) {
        equipmentRepository.deleteById(id);
    }

    public Equipment updateEquipment(Equipment equipment,Long id) {
        Equipment updateEquipment = equipmentRepository.findById(id).get();
        updateEquipment.setName(equipment.getName());
        updateEquipment.setDescription(equipment.getDescription());
        updateEquipment.setImage(equipment.getImage());
        updateEquipment.setType(equipment.getType());
        updateEquipment.setEquipmentStatus(equipment.getEquipmentStatus());
        return equipmentRepository.save(updateEquipment);

    }

}
