package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.LipidProfile;
import com.sachini.labappointmentsys.repository.LipidProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LipidProfileService {
    @Autowired
    private LipidProfileRepository lipidProfileRepository;

    public List<LipidProfile> getAllLipidProfiles() {
        return lipidProfileRepository.findAll();
    }

    public Optional<LipidProfile> getLipidProfileById(Long id) {
        return lipidProfileRepository.findById(id);
    }

    public LipidProfile createLipidProfile(LipidProfile lipidProfile) {
        return lipidProfileRepository.save(lipidProfile);
    }

    public LipidProfile updateLipidProfile(Long id, LipidProfile lipidProfile) {
        if (lipidProfileRepository.existsById(id)) {
            lipidProfile.setId(id);
            return lipidProfileRepository.save(lipidProfile);
        }
        return null; // Or throw an exception
    }

    public boolean deleteLipidProfile(Long id) {
        if (lipidProfileRepository.existsById(id)) {
            lipidProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
