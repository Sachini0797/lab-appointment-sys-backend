package com.sachini.labappointmentsys.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendRegistrationEmail(String to, Long userId, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Registration Successful");
        message.setText("Dear " + username + ",\n\nThank you for registering with us!\n\nYour user ID is: " + userId);
        emailSender.send(message);
    }

    public void sendAppointmentEmail(String to, Long userId, Long appointmentId, String username, LocalDate appointmentDate, LocalTime startTime, LocalTime endTime) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Appointment Details Confirmation: " + appointmentId);
        message.setText("Dear " + username+ ",\n" +
                "\n" +
                "We are pleased to confirm your upcoming appointment with us. Here are the details:\n" +
                "\n" +
                "Appointment ID: " +appointmentId +"\n" +
                "Date: " +appointmentDate +"\n" +
                "Start Time: "+startTime+"\n" +
                "End Time: "+endTime+"\n" +
                "\n" +
                "Please make sure to mark your calendar accordingly. If for any reason you need to reschedule or cancel your appointment, kindly let us know at least 24 hours in advance.");
        emailSender.send(message);
    }


}
