package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.LabTest;
import com.sachini.labappointmentsys.security.services.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin/labtests")
public class LabTestController {
    @Autowired
    private LabTestService labTestService;

    @GetMapping("/all")
    public List<LabTest> getAllLabTests() {
        return labTestService.getAllLabTests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTest> getLabTestById(@PathVariable("id") Long id) {
        Optional<LabTest> labTestOptional = labTestService.getLabTestById(id);
        return labTestOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public LabTest createLabTest(@RequestBody LabTest labTest) {
        return labTestService.createLabTest(labTest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LabTest> updateLabTest(@PathVariable("id") Long id, @RequestBody LabTest labTest) {
        LabTest updatedLabTest = labTestService.updateLabTest(id, labTest);
        return updatedLabTest != null ? ResponseEntity.ok(updatedLabTest) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTest(@PathVariable("id") Long id) {
        boolean deleted = labTestService.deleteLabTest(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
