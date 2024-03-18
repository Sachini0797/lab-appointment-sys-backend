package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.LabTechnician;
import com.sachini.labappointmentsys.security.services.LabTechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/technician")
public class LabTechnicianController {

    @Autowired
    private LabTechnicianService labTechnicianService;

    @PostMapping("/create")
    public ResponseEntity<LabTechnician> createTechnician(@RequestBody LabTechnician technician) {
        LabTechnician createdTechnician = labTechnicianService.createTechnician(technician);
        return new ResponseEntity<>(createdTechnician, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTechnician> getTechnicianById(@PathVariable Long id) {
        LabTechnician technician = labTechnicianService.getTechnicianById(id);
        return ResponseEntity.ok(technician);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LabTechnician>> getAllTechnicians() {
        List<LabTechnician> technicians = labTechnicianService.getAllTechnicians();
        return ResponseEntity.ok(technicians);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LabTechnician> updateTechnician(@PathVariable Long id, @RequestBody LabTechnician updatedTechnician) {
        LabTechnician technician = labTechnicianService.updateTechnician(id, updatedTechnician);
        return ResponseEntity.ok(technician);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnician(@PathVariable Long id) {
        labTechnicianService.deleteTechnician(id);
        return ResponseEntity.noContent().build();
    }
}
