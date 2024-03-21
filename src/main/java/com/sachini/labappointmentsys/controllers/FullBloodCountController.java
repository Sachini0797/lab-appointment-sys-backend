package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.FullBloodCount;
import com.sachini.labappointmentsys.security.services.FullBloodCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/report/full-blood-counts")
public class FullBloodCountController {
    @Autowired
    private FullBloodCountService fullBloodCountService;

    @GetMapping
    public ResponseEntity<List<FullBloodCount>> getAllFullBloodCounts() {
        List<FullBloodCount> fullBloodCounts = fullBloodCountService.getAllFullBloodCounts();
        return new ResponseEntity<>(fullBloodCounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FullBloodCount> getFullBloodCountById(@PathVariable("id") Long id) {
        Optional<FullBloodCount> fullBloodCount = fullBloodCountService.getFullBloodCountById(id);
        return fullBloodCount.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<FullBloodCount> createFullBloodCount(@RequestBody FullBloodCount fullBloodCount) {
        FullBloodCount createdFullBloodCount = fullBloodCountService.createFullBloodCount(fullBloodCount);
        return new ResponseEntity<>(createdFullBloodCount, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FullBloodCount> updateFullBloodCount(@PathVariable("id") Long id, @RequestBody FullBloodCount fullBloodCount) {
        FullBloodCount updatedFullBloodCount = fullBloodCountService.updateFullBloodCount(id, fullBloodCount);
        if (updatedFullBloodCount != null) {
            return new ResponseEntity<>(updatedFullBloodCount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFullBloodCount(@PathVariable("id") Long id) {
        if (fullBloodCountService.deleteFullBloodCount(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
