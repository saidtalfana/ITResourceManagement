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


    @PostMapping("/add_equipment")
    public Equipment addEquipment(@RequestBody Equipment equipment,@RequestParam Long user_id) {
        return equipmentService.addEquipment(equipment, user_id);
    }

    @GetMapping("/get_equipment/{id}")
    public Equipment getEquipment(@PathVariable Long id) {
        return equipmentService.getEquipment(id);
    }
    @GetMapping("/get_equipment_by_user_id/{user_id}")
    public List<Equipment> getEquipmentsByUserId(@PathVariable Long user_id) {
        return equipmentService.getEquipmentsByUserId(user_id);
    }

    @GetMapping("all_equipment")
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @DeleteMapping("/delete_equipment/{id}")
    public void deleteEquipment(@PathVariable long id) {
        equipmentService.deleteEquipmentById(id);
    }

    @PutMapping("/update_equipment/{equipment_id}")
    public Equipment updateEquipment(@RequestBody Equipment equipment,@PathVariable Long equipment_id,@RequestParam Long user_id) {
        return equipmentService.updateEquipment(equipment,equipment_id,user_id);
    }
}
