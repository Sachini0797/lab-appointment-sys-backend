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

    public AlkalinePhosphatase findByUniqueIdentifier(Long appointmentId) {
        // Implement logic to find AlkalinePhosphatase by appointmentId using your repository
        return alkalinePhosphataseRepository.findByAppointmentId(appointmentId);
    }

    public List<AlkalinePhosphatase> getReportsForUid(Long uid) {
        return alkalinePhosphataseRepository.findAllByUid(uid);
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

//    public List<AlkalinePhosphatase> findByAppointmentIdAndLabTestId(Long appointmentId, Long testNo) {
//        return alkalinePhosphataseRepository.findByAppointmentIdAndLabTestId(appointmentId, testNo);
//    }

//    public AlkalinePhosphatase findOneByAppointmentId(Long appointmentId) {
//        return alkalinePhosphataseRepository.findByAppointmentId(appointmentId);
//    }
}
