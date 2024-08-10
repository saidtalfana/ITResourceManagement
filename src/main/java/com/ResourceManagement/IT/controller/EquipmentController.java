package com.ResourceManagement.IT.controller;

import com.ResourceManagement.IT.model.Equipment;
import com.ResourceManagement.IT.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;


//    @PostMapping("/add_equipment}")
//    public Equipment addEquipment(@RequestBody Equipment equipment) {
//        return equipmentService.addEquipment(equipment);
//    }

    @GetMapping("/all_equipment")
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @DeleteMapping("/delete_equipment/{user_id}")
    public void deleteEquipment(@PathVariable long user_id) {
        equipmentService.deleteEquipmentById(user_id);
    }

    @PutMapping("/update_equipment/{equipment_id}")
    public Equipment updateEquipment(@RequestBody Equipment equipment,@PathVariable long equipment_id) {
        return equipmentService.updateEquipment(equipment,equipment_id);
    }
}
