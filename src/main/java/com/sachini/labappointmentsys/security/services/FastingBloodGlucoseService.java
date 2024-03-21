package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.FastingBloodGlucose;
import com.sachini.labappointmentsys.repository.FastingBloodGlucoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FastingBloodGlucoseService {
    @Autowired
    private FastingBloodGlucoseRepository fastingBloodGlucoseRepository;

    public List<FastingBloodGlucose> getAllFastingBloodGlucose() {
        return fastingBloodGlucoseRepository.findAll();
    }

    public Optional<FastingBloodGlucose> getFastingBloodGlucoseById(Long id) {
        return fastingBloodGlucoseRepository.findById(id);
    }

    public FastingBloodGlucose createFastingBloodGlucose(FastingBloodGlucose fastingBloodGlucose) {
        return fastingBloodGlucoseRepository.save(fastingBloodGlucose);
    }

    public FastingBloodGlucose updateFastingBloodGlucose(Long id, FastingBloodGlucose fastingBloodGlucose) {
        if (fastingBloodGlucoseRepository.existsById(id)) {
            fastingBloodGlucose.setId(id);
            return fastingBloodGlucoseRepository.save(fastingBloodGlucose);
        }
        return null; // Or throw an exception
    }

    public boolean deleteFastingBloodGlucose(Long id) {
        if (fastingBloodGlucoseRepository.existsById(id)) {
            fastingBloodGlucoseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
