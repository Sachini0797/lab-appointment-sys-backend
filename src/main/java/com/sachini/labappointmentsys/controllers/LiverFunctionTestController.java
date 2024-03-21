package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.LiverFunctionTest;
import com.sachini.labappointmentsys.security.services.LiverFunctionTestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/report/liver-function-tests")
public class LiverFunctionTestController {
    private final LiverFunctionTestService liverFunctionTestService;

    @Autowired
    public LiverFunctionTestController(LiverFunctionTestService liverFunctionTestService) {
        this.liverFunctionTestService = liverFunctionTestService;
    }

    @GetMapping
    public ResponseEntity<List<LiverFunctionTest>> getAllLiverFunctionTests() {
        List<LiverFunctionTest> liverFunctionTests = liverFunctionTestService.getAllLiverFunctionTests();
        return ResponseEntity.ok(liverFunctionTests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LiverFunctionTest> getLiverFunctionTestById(@PathVariable Long id) {
        Optional<LiverFunctionTest> liverFunctionTest = liverFunctionTestService.getLiverFunctionTestById(id);
        return liverFunctionTest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LiverFunctionTest> createLiverFunctionTest(@Valid @RequestBody LiverFunctionTest liverFunctionTest) {
        LiverFunctionTest createdLiverFunctionTest = liverFunctionTestService.createLiverFunctionTest(liverFunctionTest);
        return new ResponseEntity<>(createdLiverFunctionTest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LiverFunctionTest> updateLiverFunctionTest(@PathVariable Long id, @Valid @RequestBody LiverFunctionTest liverFunctionTest) {
        LiverFunctionTest updatedLiverFunctionTest = liverFunctionTestService.updateLiverFunctionTest(id, liverFunctionTest);
        if (updatedLiverFunctionTest != null) {
            return ResponseEntity.ok(updatedLiverFunctionTest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLiverFunctionTest(@PathVariable Long id) {
        if (liverFunctionTestService.deleteLiverFunctionTest(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
