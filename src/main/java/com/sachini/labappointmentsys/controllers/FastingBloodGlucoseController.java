package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.FastingBloodGlucose;
import com.sachini.labappointmentsys.security.services.FastingBloodGlucoseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/report/fasting-blood-glucose")
public class FastingBloodGlucoseController {
    @Autowired
    private FastingBloodGlucoseService fastingBloodGlucoseService;

    @GetMapping("/all")
    public ResponseEntity<List<FastingBloodGlucose>> getAllFastingBloodGlucose() {
        List<FastingBloodGlucose> fastingBloodGlucoseList = fastingBloodGlucoseService.getAllFastingBloodGlucose();
        return new ResponseEntity<>(fastingBloodGlucoseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FastingBloodGlucose> getFastingBloodGlucoseById(@PathVariable("id") Long id) {
        Optional<FastingBloodGlucose> fastingBloodGlucose = fastingBloodGlucoseService.getFastingBloodGlucoseById(id);
        return fastingBloodGlucose.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<FastingBloodGlucose> createFastingBloodGlucose(@Valid @RequestBody FastingBloodGlucose fastingBloodGlucose) {
        FastingBloodGlucose createdFastingBloodGlucose = fastingBloodGlucoseService.createFastingBloodGlucose(fastingBloodGlucose);
        return new ResponseEntity<>(createdFastingBloodGlucose, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FastingBloodGlucose> updateFastingBloodGlucose(@PathVariable("id") Long id, @Valid @RequestBody FastingBloodGlucose fastingBloodGlucose) {
        FastingBloodGlucose updatedFastingBloodGlucose = fastingBloodGlucoseService.updateFastingBloodGlucose(id, fastingBloodGlucose);
        if (updatedFastingBloodGlucose != null) {
            return new ResponseEntity<>(updatedFastingBloodGlucose, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFastingBloodGlucose(@PathVariable("id") Long id) {
        if (fastingBloodGlucoseService.deleteFastingBloodGlucose(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
