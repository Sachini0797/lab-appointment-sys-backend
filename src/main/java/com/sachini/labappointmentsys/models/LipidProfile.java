package com.sachini.labappointmentsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LipidProfile {
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
    private Double totalCholesterolValue;
    private Double serumTriglyceridesValue;
    private Double hdlCholesterolValue;
    private Double ldlCholesterolValue;
    private Double vldlCholesterolValue;
    private Double totalCholesterolHdlValue;
    private String refNo;
    private String refBy;
    private String remarks;

    public LipidProfile() {}

    public LipidProfile(Long uid, Long appointmentId, Boolean completed, LocalDateTime createdDate, LocalDateTime sampleCollectedDate, LocalDateTime sampleReceivedDate, LocalDateTime reportAuthorizedDate, Double totalCholesterolValue, Double serumTriglyceridesValue, Double hdlCholesterolValue, Double ldlCholesterolValue, Double vldlCholesterolValue, Double totalCholesterolHdlValue, String refNo, String refBy, String remarks) {
        this.uid = uid;
        this.appointmentId = appointmentId;
        this.completed = completed;
        this.createdDate = createdDate;
        this.sampleCollectedDate = sampleCollectedDate;
        this.sampleReceivedDate = sampleReceivedDate;
        this.reportAuthorizedDate = reportAuthorizedDate;
        this.totalCholesterolValue = totalCholesterolValue;
        this.serumTriglyceridesValue = serumTriglyceridesValue;
        this.hdlCholesterolValue = hdlCholesterolValue;
        this.ldlCholesterolValue = ldlCholesterolValue;
        this.vldlCholesterolValue = vldlCholesterolValue;
        this.totalCholesterolHdlValue = totalCholesterolHdlValue;
        this.refNo = refNo;
        this.refBy = refBy;
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

    public Double getTotalCholesterolValue() {
        return totalCholesterolValue;
    }

    public void setTotalCholesterolValue(Double totalCholesterolValue) {
        this.totalCholesterolValue = totalCholesterolValue;
    }

    public Double getSerumTriglyceridesValue() {
        return serumTriglyceridesValue;
    }

    public void setSerumTriglyceridesValue(Double serumTriglyceridesValue) {
        this.serumTriglyceridesValue = serumTriglyceridesValue;
    }

    public Double getHdlCholesterolValue() {
        return hdlCholesterolValue;
    }

    public void setHdlCholesterolValue(Double hdlCholesterolValue) {
        this.hdlCholesterolValue = hdlCholesterolValue;
    }

    public Double getLdlCholesterolValue() {
        return ldlCholesterolValue;
    }

    public void setLdlCholesterolValue(Double ldlCholesterolValue) {
        this.ldlCholesterolValue = ldlCholesterolValue;
    }

    public Double getVldlCholesterolValue() {
        return vldlCholesterolValue;
    }

    public void setVldlCholesterolValue(Double vldlCholesterolValue) {
        this.vldlCholesterolValue = vldlCholesterolValue;
    }

    public Double getTotalCholesterolHdlValue() {
        return totalCholesterolHdlValue;
    }

    public void setTotalCholesterolHdlValue(Double totalCholesterolHdlValue) {
        this.totalCholesterolHdlValue = totalCholesterolHdlValue;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
