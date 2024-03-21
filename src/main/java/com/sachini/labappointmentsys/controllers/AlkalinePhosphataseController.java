package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.AlkalinePhosphatase;
import com.sachini.labappointmentsys.security.services.AlkalinePhosphataseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/report/alkaline-phosphatases")
public class AlkalinePhosphataseController {
    @Autowired
    private AlkalinePhosphataseService alkalinePhosphataseService;

    @GetMapping("/all")
    public ResponseEntity<List<AlkalinePhosphatase>> getAllAlkalinePhosphatases() {
        List<AlkalinePhosphatase> alkalinePhosphatases = alkalinePhosphataseService.getAllAlkalinePhosphatases();
        return ResponseEntity.ok(alkalinePhosphatases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlkalinePhosphatase> getAlkalinePhosphataseById(@PathVariable("id") Long id) {
        Optional<AlkalinePhosphatase> alkalinePhosphatase = alkalinePhosphataseService.getAlkalinePhosphataseById(id);
        return alkalinePhosphatase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<AlkalinePhosphatase> createAlkalinePhosphatase(@Valid @RequestBody AlkalinePhosphatase alkalinePhosphatase) {
        AlkalinePhosphatase createdAlkalinePhosphatase = alkalinePhosphataseService.createAlkalinePhosphatase(alkalinePhosphatase);
        return new ResponseEntity<>(createdAlkalinePhosphatase, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlkalinePhosphatase> updateAlkalinePhosphatase(@PathVariable("id") Long id, @Valid @RequestBody AlkalinePhosphatase alkalinePhosphatase) {
        AlkalinePhosphatase updatedAlkalinePhosphatase = alkalinePhosphataseService.updateAlkalinePhosphatase(id, alkalinePhosphatase);
        return updatedAlkalinePhosphatase != null ? ResponseEntity.ok(updatedAlkalinePhosphatase) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlkalinePhosphatase(@PathVariable("id") Long id) {
        boolean deleted = alkalinePhosphataseService.deleteAlkalinePhosphatase(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
