package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.DengueAntibodyIggIgm;
import com.sachini.labappointmentsys.security.services.DengueAntibodyIggIgmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/report/dengue-antibody-igg-igm")
public class DengueAntibodyIggIgmController {
    @Autowired
    private DengueAntibodyIggIgmService dengueAntibodyIggIgmService;

    @GetMapping("/all")
    public ResponseEntity<List<DengueAntibodyIggIgm>> getAllDengueAntibodyIggIgms() {
        List<DengueAntibodyIggIgm> dengueAntibodyIggIgms = dengueAntibodyIggIgmService.getAllDengueAntibodyIggIgms();
        return new ResponseEntity<>(dengueAntibodyIggIgms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DengueAntibodyIggIgm> getDengueAntibodyIggIgmById(@PathVariable Long id) {
        Optional<DengueAntibodyIggIgm> dengueAntibodyIggIgm = dengueAntibodyIggIgmService.getDengueAntibodyIggIgmById(id);
        return dengueAntibodyIggIgm.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<DengueAntibodyIggIgm> createDengueAntibodyIggIgm(@Valid @RequestBody DengueAntibodyIggIgm dengueAntibodyIggIgm) {
        DengueAntibodyIggIgm createdDengueAntibodyIggIgm = dengueAntibodyIggIgmService.createDengueAntibodyIggIgm(dengueAntibodyIggIgm);
        return new ResponseEntity<>(createdDengueAntibodyIggIgm, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DengueAntibodyIggIgm> updateDengueAntibodyIggIgm(@PathVariable Long id, @Valid @RequestBody DengueAntibodyIggIgm dengueAntibodyIggIgm) {
        DengueAntibodyIggIgm updatedDengueAntibodyIggIgm = dengueAntibodyIggIgmService.updateDengueAntibodyIggIgm(id, dengueAntibodyIggIgm);
        return updatedDengueAntibodyIggIgm != null ? new ResponseEntity<>(updatedDengueAntibodyIggIgm, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDengueAntibodyIggIgm(@PathVariable Long id) {
        if (dengueAntibodyIggIgmService.deleteDengueAntibodyIggIgm(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
