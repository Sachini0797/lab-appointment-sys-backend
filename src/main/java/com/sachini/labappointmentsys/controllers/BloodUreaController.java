package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.BloodUrea;
import com.sachini.labappointmentsys.security.services.BloodUreaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/api/report/blood-urea")
@RestController
public class BloodUreaController {
    @Autowired
    private BloodUreaService bloodUreaService;

    @GetMapping("/all")
    public ResponseEntity<List<BloodUrea>> getAllBloodUrea() {
        List<BloodUrea> bloodUreaList = bloodUreaService.getAllBloodUrea();
        return ResponseEntity.ok(bloodUreaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodUrea> getBloodUreaById(@PathVariable Long id) {
        Optional<BloodUrea> bloodUrea = bloodUreaService.getBloodUreaById(id);
        return bloodUrea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<BloodUrea> createBloodUrea(@Valid @RequestBody BloodUrea bloodUrea) {
        BloodUrea createdBloodUrea = bloodUreaService.createBloodUrea(bloodUrea);
        return new ResponseEntity<>(createdBloodUrea, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BloodUrea> updateBloodUrea(@PathVariable Long id, @Valid @RequestBody BloodUrea bloodUrea) {
        BloodUrea updatedBloodUrea = bloodUreaService.updateBloodUrea(id, bloodUrea);
        if (updatedBloodUrea != null) {
            return ResponseEntity.ok(updatedBloodUrea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBloodUrea(@PathVariable Long id) {
        if (bloodUreaService.deleteBloodUrea(id)) {
            return ResponseEntity.ok("Blood Urea deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
