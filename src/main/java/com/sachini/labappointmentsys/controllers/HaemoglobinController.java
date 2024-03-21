package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.Haemoglobin;
import com.sachini.labappointmentsys.security.services.HaemoglobinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/report/haemoglobin")
public class HaemoglobinController {
    @Autowired
    private HaemoglobinService haemoglobinService;

    @GetMapping("/all")
    public ResponseEntity<List<Haemoglobin>> getAllHaemoglobinTests() {
        List<Haemoglobin> haemoglobinTests = haemoglobinService.getAllHaemoglobinTests();
        return ResponseEntity.ok(haemoglobinTests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Haemoglobin> getHaemoglobinTestById(@PathVariable Long id) {
        Optional<Haemoglobin> haemoglobinTest = haemoglobinService.getHaemoglobinTestById(id);
        return haemoglobinTest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Haemoglobin> createHaemoglobinTest(@RequestBody Haemoglobin haemoglobin) {
        Haemoglobin createdHaemoglobin = haemoglobinService.createHaemoglobinTest(haemoglobin);
        return new ResponseEntity<>(createdHaemoglobin, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Haemoglobin> updateHaemoglobinTest(@PathVariable Long id, @RequestBody Haemoglobin haemoglobin) {
        Haemoglobin updatedHaemoglobin = haemoglobinService.updateHaemoglobinTest(id, haemoglobin);
        if (updatedHaemoglobin != null) {
            return ResponseEntity.ok(updatedHaemoglobin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHaemoglobinTest(@PathVariable Long id) {
        boolean deleted = haemoglobinService.deleteHaemoglobinTest(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
