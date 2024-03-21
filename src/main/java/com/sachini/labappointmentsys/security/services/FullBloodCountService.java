package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.FullBloodCount;
import com.sachini.labappointmentsys.repository.FullBloodCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FullBloodCountService {
    @Autowired
    private FullBloodCountRepository fullBloodCountRepository;

    public List<FullBloodCount> getAllFullBloodCounts() {
        return fullBloodCountRepository.findAll();
    }

    public Optional<FullBloodCount> getFullBloodCountById(Long id) {
        return fullBloodCountRepository.findById(id);
    }

    public FullBloodCount createFullBloodCount(FullBloodCount fullBloodCount) {
        return fullBloodCountRepository.save(fullBloodCount);
    }

    public FullBloodCount updateFullBloodCount(Long id, FullBloodCount fullBloodCount) {
        if (fullBloodCountRepository.existsById(id)) {
            fullBloodCount.setId(id);
            return fullBloodCountRepository.save(fullBloodCount);
        }
        return null; // Or throw an exception
    }

    public boolean deleteFullBloodCount(Long id) {
        if (fullBloodCountRepository.existsById(id)) {
            fullBloodCountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
