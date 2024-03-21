package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.AlkalinePhosphatase;
import com.sachini.labappointmentsys.repository.AlkalinePhosphataseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlkalinePhosphataseService {
    @Autowired
    private AlkalinePhosphataseRepository alkalinePhosphataseRepository;

    public List<AlkalinePhosphatase> getAllAlkalinePhosphatases() {
        return alkalinePhosphataseRepository.findAll();
    }

    public Optional<AlkalinePhosphatase> getAlkalinePhosphataseById(Long id) {
        return alkalinePhosphataseRepository.findById(id);
    }

    public AlkalinePhosphatase createAlkalinePhosphatase(AlkalinePhosphatase alkalinePhosphatase) {
        return alkalinePhosphataseRepository.save(alkalinePhosphatase);
    }

    public AlkalinePhosphatase updateAlkalinePhosphatase(Long id, AlkalinePhosphatase alkalinePhosphatase) {
        if (alkalinePhosphataseRepository.existsById(id)) {
            alkalinePhosphatase.setId(id);
            return alkalinePhosphataseRepository.save(alkalinePhosphatase);
        }
        return null; // Or throw an exception
    }

    public boolean deleteAlkalinePhosphatase(Long id) {
        if (alkalinePhosphataseRepository.existsById(id)) {
            alkalinePhosphataseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
