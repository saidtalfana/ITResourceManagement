package com.ResourceManagement.IT.controller;

import com.ResourceManagement.IT.model.Failure;
import com.ResourceManagement.IT.service.FailureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/failure")
public class FailureController {

    @Autowired
    private FailureService failureService;

    @PostMapping("/add_failure")
    public Failure addFailure(@RequestBody Failure failure) {
        return failureService.addFailure(failure);
    }

    @GetMapping("/get_failures")
    public List<Failure> getFailures() {
        return failureService.getAllFailures();
    }
}
