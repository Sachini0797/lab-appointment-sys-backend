package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.DengueNsiRapidipTest;
import com.sachini.labappointmentsys.repository.DengueNsiRapidipTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DengueNsiRapidipTestService {
    @Autowired
    private DengueNsiRapidipTestRepository dengueNsiRapidipTestRepository;

    public List<DengueNsiRapidipTest> getAllTests() {
        return dengueNsiRapidipTestRepository.findAll();
    }

    public Optional<DengueNsiRapidipTest> getTestById(Long id) {
        return dengueNsiRapidipTestRepository.findById(id);
    }

    public DengueNsiRapidipTest createTest(DengueNsiRapidipTest test) {
        return dengueNsiRapidipTestRepository.save(test);
    }

    public DengueNsiRapidipTest updateTest(Long id, DengueNsiRapidipTest test) {
        if (dengueNsiRapidipTestRepository.existsById(id)) {
            test.setId(id);
            return dengueNsiRapidipTestRepository.save(test);
        }
        return null; // Or throw an exception
    }

    public boolean deleteTest(Long id) {
        if (dengueNsiRapidipTestRepository.existsById(id)) {
            dengueNsiRapidipTestRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
