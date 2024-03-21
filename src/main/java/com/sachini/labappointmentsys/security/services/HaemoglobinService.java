package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.Haemoglobin;
import com.sachini.labappointmentsys.repository.HaemoglobinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HaemoglobinService {
    @Autowired
    private HaemoglobinRepository haemoglobinRepository;

    public List<Haemoglobin> getAllHaemoglobinTests() {
        return haemoglobinRepository.findAll();
    }

    public Optional<Haemoglobin> getHaemoglobinTestById(Long id) {
        return haemoglobinRepository.findById(id);
    }

    public Haemoglobin createHaemoglobinTest(Haemoglobin haemoglobin) {
        return haemoglobinRepository.save(haemoglobin);
    }

    public Haemoglobin updateHaemoglobinTest(Long id, Haemoglobin haemoglobin) {
        if (haemoglobinRepository.existsById(id)) {
            haemoglobin.setId(id);
            return haemoglobinRepository.save(haemoglobin);
        }
        return null; // Or throw an exception
    }

    public boolean deleteHaemoglobinTest(Long id) {
        if (haemoglobinRepository.existsById(id)) {
            haemoglobinRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
