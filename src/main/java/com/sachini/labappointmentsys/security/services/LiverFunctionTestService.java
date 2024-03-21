package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.LiverFunctionTest;
import com.sachini.labappointmentsys.repository.LiverFunctionTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiverFunctionTestService {
    private final LiverFunctionTestRepository liverFunctionTestRepository;

    @Autowired
    public LiverFunctionTestService(LiverFunctionTestRepository liverFunctionTestRepository) {
        this.liverFunctionTestRepository = liverFunctionTestRepository;
    }

    public List<LiverFunctionTest> getAllLiverFunctionTests() {
        return liverFunctionTestRepository.findAll();
    }

    public Optional<LiverFunctionTest> getLiverFunctionTestById(Long id) {
        return liverFunctionTestRepository.findById(id);
    }

    public LiverFunctionTest createLiverFunctionTest(LiverFunctionTest liverFunctionTest) {
        return liverFunctionTestRepository.save(liverFunctionTest);
    }

    public LiverFunctionTest updateLiverFunctionTest(Long id, LiverFunctionTest liverFunctionTest) {
        if (liverFunctionTestRepository.existsById(id)) {
            liverFunctionTest.setId(id);
            return liverFunctionTestRepository.save(liverFunctionTest);
        }
        return null; // Or throw an exception
    }

    public boolean deleteLiverFunctionTest(Long id) {
        if (liverFunctionTestRepository.existsById(id)) {
            liverFunctionTestRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
