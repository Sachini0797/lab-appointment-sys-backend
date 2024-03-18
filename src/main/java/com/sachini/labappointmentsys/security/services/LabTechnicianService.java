package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.LabTechnician;
import com.sachini.labappointmentsys.repository.LabTechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabTechnicianService {
    @Autowired
    private LabTechnicianRepository labTechnicianRepository;

    public LabTechnician createTechnician(LabTechnician technician) {
        return labTechnicianRepository.save(technician);
    }

    public List<LabTechnician> getAllTechnicians() {
        return labTechnicianRepository.findAll();
    }

    public LabTechnician getTechnicianById(Long id) {
        Optional<LabTechnician> technicianOptional = labTechnicianRepository.findById(id);
        if (technicianOptional.isPresent()) {
            return technicianOptional.get();
        } else {
            throw new IllegalArgumentException("LabTechnician not found");
        }
    }

    public LabTechnician updateTechnician(Long id, LabTechnician updatedTechnician) {
        Optional<LabTechnician> technicianOptional = labTechnicianRepository.findById(id);
        if (technicianOptional.isPresent()) {
            updatedTechnician.setId(id);
            return labTechnicianRepository.save(updatedTechnician);
        } else {
            throw new IllegalArgumentException("LabTechnician not found");
        }
    }

    public void deleteTechnician(Long id) {
        Optional<LabTechnician> technicianOptional = labTechnicianRepository.findById(id);
        if (technicianOptional.isPresent()) {
            labTechnicianRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("LabTechnician not found");
        }
    }
}
