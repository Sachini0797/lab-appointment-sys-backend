package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.DengueNsiRapidipTest;
import com.sachini.labappointmentsys.security.services.DengueNsiRapidipTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/report/dengue-nsi-rapidip")
public class DengueNsiRapidipTestController {
    @Autowired
    private DengueNsiRapidipTestService dengueNsiRapidipTestService;

    @GetMapping
    public ResponseEntity<List<DengueNsiRapidipTest>> getAllTests() {
        List<DengueNsiRapidipTest> tests = dengueNsiRapidipTestService.getAllTests();
        return ResponseEntity.ok(tests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DengueNsiRapidipTest> getTestById(@PathVariable Long id) {
        Optional<DengueNsiRapidipTest> test = dengueNsiRapidipTestService.getTestById(id);
        return test.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DengueNsiRapidipTest> createTest(@RequestBody DengueNsiRapidipTest test) {
        DengueNsiRapidipTest createdTest = dengueNsiRapidipTestService.createTest(test);
        return new ResponseEntity<>(createdTest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DengueNsiRapidipTest> updateTest(@PathVariable Long id, @RequestBody DengueNsiRapidipTest test) {
        DengueNsiRapidipTest updatedTest = dengueNsiRapidipTestService.updateTest(id, test);
        if (updatedTest != null) {
            return ResponseEntity.ok(updatedTest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        if (dengueNsiRapidipTestService.deleteTest(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
