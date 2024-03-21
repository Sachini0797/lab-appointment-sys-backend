package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.Appointment;
import com.sachini.labappointmentsys.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            return appointmentOptional.get();
        } else {
            throw new IllegalArgumentException("Appointment not found");
        }
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            updatedAppointment.setId(id);
            return appointmentRepository.save(updatedAppointment);
        } else {
            throw new IllegalArgumentException("Appointment not found");
        }
    }

    public void deleteAppointment(Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            appointmentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Appointment not found");
        }
    }
    public boolean isTechnicianAvailable(Long technicianId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Appointment> conflictingAppointments = appointmentRepository.findConflictingAppointments(
                technicianId, date, startTime, endTime);
        return conflictingAppointments.isEmpty();
    }

    public boolean createOrUpdateAppointment(Appointment appointment) {
        Long technicianId = appointment.getLabTechnician().getId();
        LocalDate appointmentDate = appointment.getAppointmentDate();
        LocalTime startTime = appointment.getStartTime();
        LocalTime endTime = appointment.getEndTime();

        if (isTechnicianAvailable(technicianId, appointmentDate, startTime, endTime)) {
            appointmentRepository.save(appointment);
            return true; // Appointment created/updated successfully
        } else {
            return false; // Technician not available
        }
    }

}
