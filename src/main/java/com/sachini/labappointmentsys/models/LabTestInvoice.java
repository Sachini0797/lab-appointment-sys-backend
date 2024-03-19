package com.sachini.labappointmentsys.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LabTestInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;


    private LocalDateTime generatedAt;

    private double billAmount;
    private double discount;
    private double totalAmount;
    private double paidAmount;
    private double dueAmount;
    private double remarks;

    private double paymentStatus;

    public LabTestInvoice() {}

    public LabTestInvoice(Appointment appointment, LocalDateTime generatedAt, double billAmount, double discount, double totalAmount, double paidAmount, double dueAmount, double remarks, double paymentStatus) {
        this.appointment = appointment;
        this.generatedAt = generatedAt;
        this.billAmount = billAmount;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.remarks = remarks;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getRemarks() {
        return remarks;
    }

    public void setRemarks(double remarks) {
        this.remarks = remarks;
    }

    public double getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(double paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
