package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.LipidProfile;
import com.sachini.labappointmentsys.security.services.LipidProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/report/lipid-profiles")
public class LipidProfileController {
    @Autowired
    private LipidProfileService lipidProfileService;

    @GetMapping
    public ResponseEntity<List<LipidProfile>> getAllLipidProfiles() {
        List<LipidProfile> lipidProfiles = lipidProfileService.getAllLipidProfiles();
        return new ResponseEntity<>(lipidProfiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LipidProfile> getLipidProfileById(@PathVariable("id") Long id) {
        Optional<LipidProfile> lipidProfile = lipidProfileService.getLipidProfileById(id);
        return lipidProfile.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<LipidProfile> createLipidProfile(@RequestBody LipidProfile lipidProfile) {
        LipidProfile createdLipidProfile = lipidProfileService.createLipidProfile(lipidProfile);
        return new ResponseEntity<>(createdLipidProfile, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LipidProfile> updateLipidProfile(@PathVariable("id") Long id, @RequestBody LipidProfile lipidProfile) {
        LipidProfile updatedLipidProfile = lipidProfileService.updateLipidProfile(id, lipidProfile);
        if (updatedLipidProfile != null) {
            return new ResponseEntity<>(updatedLipidProfile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLipidProfile(@PathVariable("id") Long id) {
        boolean deleted = lipidProfileService.deleteLipidProfile(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
