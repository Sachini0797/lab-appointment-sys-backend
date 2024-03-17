package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.LabTest;
import com.sachini.labappointmentsys.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabTestService {
    @Autowired
    private LabTestRepository labTestRepository;

    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }

    public Optional<LabTest> getLabTestById(Long id) {
        return labTestRepository.findById(id);
    }

    public LabTest createLabTest(LabTest labTest) {
        return labTestRepository.save(labTest);
    }

    public LabTest updateLabTest(Long id, LabTest labTest) {
        if (labTestRepository.existsById(id)) {
            labTest.setId(id);
            return labTestRepository.save(labTest);
        }
        return null; // Or throw an exception
    }

    public boolean deleteLabTest(Long id) {
        if (labTestRepository.existsById(id)) {
            labTestRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
