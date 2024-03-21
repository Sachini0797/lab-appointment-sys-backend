package com.sachini.labappointmentsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class DengueNsiRapidipTest {
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

    private String rapidTest;

    private String remarks;

    public DengueNsiRapidipTest() {}

    public DengueNsiRapidipTest(Long uid, Long appointmentId, Boolean completed, LocalDateTime createdDate, LocalDateTime sampleCollectedDate, LocalDateTime sampleReceivedDate, LocalDateTime reportAuthorizedDate, String refNo, String refBy, String rapidTest, String remarks) {
        this.uid = uid;
        this.appointmentId = appointmentId;
        this.completed = completed;
        this.createdDate = createdDate;
        this.sampleCollectedDate = sampleCollectedDate;
        this.sampleReceivedDate = sampleReceivedDate;
        this.reportAuthorizedDate = reportAuthorizedDate;
        this.refNo = refNo;
        this.refBy = refBy;
        this.rapidTest = rapidTest;
        this.remarks = remarks;
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

    public String getRapidTest() {
        return rapidTest;
    }

    public void setRapidTest(String rapidTest) {
        this.rapidTest = rapidTest;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
