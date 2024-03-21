package com.sachini.labappointmentsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class DengueAntibodyIggIgm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long uid;
    private Long appointmentId;
    private Boolean completed;
    private LocalDateTime createdDate;
    private LocalDateTime sampleCollectedDate;
    private LocalDateTime sampleReceivedDate;
    private LocalDateTime reportAuthorizedDate;
    private String refNo;
    private String refBy;
    private String testIgg;
    private String testIgm;
    private String remarks;
    private String medicalCenterId;
    private String medicalCenterName;

    public DengueAntibodyIggIgm() {}

    public DengueAntibodyIggIgm(Long uid, Long appointmentId, Boolean completed, LocalDateTime createdDate, LocalDateTime sampleCollectedDate, LocalDateTime sampleReceivedDate, LocalDateTime reportAuthorizedDate, String refNo, String refBy, String testIgg, String testIgm, String remarks, String medicalCenterId, String medicalCenterName) {
        this.uid = uid;
        this.appointmentId = appointmentId;
        this.completed = completed;
        this.createdDate = createdDate;
        this.sampleCollectedDate = sampleCollectedDate;
        this.sampleReceivedDate = sampleReceivedDate;
        this.reportAuthorizedDate = reportAuthorizedDate;
        this.refNo = refNo;
        this.refBy = refBy;
        this.testIgg = testIgg;
        this.testIgm = testIgm;
        this.remarks = remarks;
        this.medicalCenterId = medicalCenterId;
        this.medicalCenterName = medicalCenterName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getSampleCollectedDate() {
        return sampleCollectedDate;
    }

    public void setSampleCollectedDate(LocalDateTime sampleCollectedDate) {
        this.sampleCollectedDate = sampleCollectedDate;
    }

    public LocalDateTime getSampleReceivedDate() {
        return sampleReceivedDate;
    }

    public void setSampleReceivedDate(LocalDateTime sampleReceivedDate) {
        this.sampleReceivedDate = sampleReceivedDate;
    }

    public LocalDateTime getReportAuthorizedDate() {
        return reportAuthorizedDate;
    }

    public void setReportAuthorizedDate(LocalDateTime reportAuthorizedDate) {
        this.reportAuthorizedDate = reportAuthorizedDate;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRefBy() {
        return refBy;
    }

    public void setRefBy(String refBy) {
        this.refBy = refBy;
    }

    public String getTestIgg() {
        return testIgg;
    }

    public void setTestIgg(String testIgg) {
        this.testIgg = testIgg;
    }

    public String getTestIgm() {
        return testIgm;
    }

    public void setTestIgm(String testIgm) {
        this.testIgm = testIgm;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMedicalCenterId() {
        return medicalCenterId;
    }

    public void setMedicalCenterId(String medicalCenterId) {
        this.medicalCenterId = medicalCenterId;
    }

    public String getMedicalCenterName() {
        return medicalCenterName;
    }

    public void setMedicalCenterName(String medicalCenterName) {
        this.medicalCenterName = medicalCenterName;
    }
}
