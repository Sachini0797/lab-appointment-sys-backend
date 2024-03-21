package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.DengueAntibodyIggIgm;
import com.sachini.labappointmentsys.repository.DengueAntibodyIggIgmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DengueAntibodyIggIgmService {
    @Autowired
    private DengueAntibodyIggIgmRepository dengueAntibodyIggIgmRepository;

    public List<DengueAntibodyIggIgm> getAllDengueAntibodyIggIgms() {
        return dengueAntibodyIggIgmRepository.findAll();
    }

    public Optional<DengueAntibodyIggIgm> getDengueAntibodyIggIgmById(Long id) {
        return dengueAntibodyIggIgmRepository.findById(id);
    }

    public DengueAntibodyIggIgm createDengueAntibodyIggIgm(DengueAntibodyIggIgm dengueAntibodyIggIgm) {
        return dengueAntibodyIggIgmRepository.save(dengueAntibodyIggIgm);
    }

    public DengueAntibodyIggIgm updateDengueAntibodyIggIgm(Long id, DengueAntibodyIggIgm dengueAntibodyIggIgm) {
        if (dengueAntibodyIggIgmRepository.existsById(id)) {
            dengueAntibodyIggIgm.setId(id);
            return dengueAntibodyIggIgmRepository.save(dengueAntibodyIggIgm);
        }
        return null; // Or throw an exception
    }

    public boolean deleteDengueAntibodyIggIgm(Long id) {
        if (dengueAntibodyIggIgmRepository.existsById(id)) {
            dengueAntibodyIggIgmRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
