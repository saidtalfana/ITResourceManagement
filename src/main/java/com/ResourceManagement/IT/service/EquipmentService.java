package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.model.Equipment;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.AdminRepository;
import com.ResourceManagement.IT.repository.EquipmentRepository;
import com.ResourceManagement.IT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private UserRepository userRepository;

    public Equipment addEquipment(Equipment equipment,Long user_id) {
        User user = userRepository.findById(user_id).get();
        equipment.setUser(user);
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAllEquipment() {return equipmentRepository.findAll();
    }
    public List<Equipment> getEquipmentsByUserId(Long user_id) {
        return equipmentRepository.getAllEquipmentByUserId(user_id);
    }

    public void deleteEquipmentById(Long equipment_id) {
        equipmentRepository.deleteById(equipment_id);
    }

    public Equipment updateEquipment(Equipment equipment,Long id) {
        Equipment updateEquipment = equipmentRepository.findById(id).get();
        updateEquipment.setName(equipment.getName());
        updateEquipment.setDescription(equipment.getDescription());
        updateEquipment.setImage(equipment.getImage());
        updateEquipment.setType(equipment.getType());
        updateEquipment.setUser(equipment.getUser());
        updateEquipment.setEquipmentStatus(equipment.getEquipmentStatus());
        return equipmentRepository.save(updateEquipment);

    }

}
