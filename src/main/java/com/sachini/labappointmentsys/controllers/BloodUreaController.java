package com.sachini.labappointmentsys.controllers;

 import com.sachini.labappointmentsys.models.AlkalinePhosphatase;
 import com.sachini.labappointmentsys.models.BloodUrea;
import com.sachini.labappointmentsys.security.services.BloodUreaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

//    @PostMapping("/create")
//    public ResponseEntity<BloodUrea> createBloodUrea(@Valid @RequestBody BloodUrea bloodUrea) {
//        BloodUrea createdBloodUrea = bloodUreaService.createBloodUrea(bloodUrea);
//        return new ResponseEntity<>(createdBloodUrea, HttpStatus.CREATED);
//    }

    @GetMapping("/user/{uid}")
    public List<BloodUrea> getReportsForUser(@PathVariable Long uid) {
        return bloodUreaService.getReportsForUid(uid);
    }

    @PostMapping("/create")
    public ResponseEntity<BloodUrea> createBloodUrea(@Valid @RequestBody BloodUrea bloodUrea) {
        BloodUrea existingRecord = bloodUreaService.findByUniqueIdentifier(bloodUrea.getAppointmentId()); // Assuming 'refNo' is unique
        if (existingRecord != null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("errorMessage", "Cannot create another test for this appointment. A test already exists with appointment id: " + existingRecord.getAppointmentId());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // Or create a custom error response object
        }

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

    @GetMapping("/by-appointment")
    public ResponseEntity<BloodUrea> findByAppointmentId(
            @RequestParam("appointmentId") Long appointmentId)
    {
         BloodUrea bloodUrea = bloodUreaService.findByUniqueIdentifier(appointmentId);
        return ResponseEntity.ok(bloodUrea);
    }
}
