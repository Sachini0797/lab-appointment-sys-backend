package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.BloodUrea;
import com.sachini.labappointmentsys.repository.BloodUreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodUreaService {
    @Autowired
    private BloodUreaRepository bloodUreaRepository;

    public List<BloodUrea> getAllBloodUrea() {
        return bloodUreaRepository.findAll();
    }

    public Optional<BloodUrea> getBloodUreaById(Long id) {
        return bloodUreaRepository.findById(id);
    }

    public BloodUrea createBloodUrea(BloodUrea bloodUrea) {
        return bloodUreaRepository.save(bloodUrea);
    }

    public BloodUrea updateBloodUrea(Long id, BloodUrea bloodUrea) {
        if (bloodUreaRepository.existsById(id)) {
            bloodUrea.setId(id);
            return bloodUreaRepository.save(bloodUrea);
        }
        return null; // Or throw an exception
    }

    public boolean deleteBloodUrea(Long id) {
        if (bloodUreaRepository.existsById(id)) {
            bloodUreaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
