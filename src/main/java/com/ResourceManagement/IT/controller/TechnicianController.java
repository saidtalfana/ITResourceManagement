package com.ResourceManagement.IT.controller;

import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.model.Technician;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/technician")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;


    @GetMapping("/all_technician")
    private List<Technician> getTechnician() {
        return technicianService.getAllTechnicians();
    }


    @DeleteMapping("delete_technician/{techinician_id}")
    public void deleteTechnician(@PathVariable Long techinician_id) {
        technicianService.deleteTechnician(techinician_id);
    }

}
