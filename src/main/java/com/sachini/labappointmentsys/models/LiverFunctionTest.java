package com.sachini.labappointmentsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LiverFunctionTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long uid;
    private Long appointmentId; // Added attribute
    private Boolean completed;
    private LocalDateTime createdDate;
    private LocalDateTime sampleCollectedDate;
    private LocalDateTime sampleReceivedDate;
    private LocalDateTime reportAuthorizedDate;
    private Double proteinTotalValue;
    private Double proteinAlbuminValue;
    private Double proteinGlobulinValue;
    private Double agRationValue;
    private Double sBilirubinValue;
    private Double sGPTValue;
    private Double sGOTValue;
    private Double gammaGTValue;
    private Double alkalinePhosphataseValue;
    private String refBy;
    private String refNo;
    private String remarks;

    public LiverFunctionTest() {}

    public LiverFunctionTest(Long uid, Long appointmentId, Boolean completed, LocalDateTime createdDate, LocalDateTime sampleCollectedDate, LocalDateTime sampleReceivedDate, LocalDateTime reportAuthorizedDate, Double proteinTotalValue, Double proteinAlbuminValue, Double proteinGlobulinValue, Double agRationValue, Double sBilirubinValue, Double sGPTValue, Double sGOTValue, Double gammaGTValue, Double alkalinePhosphataseValue, String refBy, String refNo, String remarks) {
        this.uid = uid;
        this.appointmentId = appointmentId;
        this.completed = completed;
        this.createdDate = createdDate;
        this.sampleCollectedDate = sampleCollectedDate;
        this.sampleReceivedDate = sampleReceivedDate;
        this.reportAuthorizedDate = reportAuthorizedDate;
        this.proteinTotalValue = proteinTotalValue;
        this.proteinAlbuminValue = proteinAlbuminValue;
        this.proteinGlobulinValue = proteinGlobulinValue;
        this.agRationValue = agRationValue;
        this.sBilirubinValue = sBilirubinValue;
        this.sGPTValue = sGPTValue;
        this.sGOTValue = sGOTValue;
        this.gammaGTValue = gammaGTValue;
        this.alkalinePhosphataseValue = alkalinePhosphataseValue;
        this.refBy = refBy;
        this.refNo = refNo;
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

    public Double getProteinTotalValue() {
        return proteinTotalValue;
    }

    public void setProteinTotalValue(Double proteinTotalValue) {
        this.proteinTotalValue = proteinTotalValue;
    }

    public Double getProteinAlbuminValue() {
        return proteinAlbuminValue;
    }

    public void setProteinAlbuminValue(Double proteinAlbuminValue) {
        this.proteinAlbuminValue = proteinAlbuminValue;
    }

    public Double getProteinGlobulinValue() {
        return proteinGlobulinValue;
    }

    public void setProteinGlobulinValue(Double proteinGlobulinValue) {
        this.proteinGlobulinValue = proteinGlobulinValue;
    }

    public Double getAgRationValue() {
        return agRationValue;
    }

    public void setAgRationValue(Double agRationValue) {
        this.agRationValue = agRationValue;
    }

    public Double getsBilirubinValue() {
        return sBilirubinValue;
    }

    public void setsBilirubinValue(Double sBilirubinValue) {
        this.sBilirubinValue = sBilirubinValue;
    }

    public Double getsGPTValue() {
        return sGPTValue;
    }

    public void setsGPTValue(Double sGPTValue) {
        this.sGPTValue = sGPTValue;
    }

    public Double getsGOTValue() {
        return sGOTValue;
    }

    public void setsGOTValue(Double sGOTValue) {
        this.sGOTValue = sGOTValue;
    }

    public Double getGammaGTValue() {
        return gammaGTValue;
    }

    public void setGammaGTValue(Double gammaGTValue) {
        this.gammaGTValue = gammaGTValue;
    }

    public Double getAlkalinePhosphataseValue() {
        return alkalinePhosphataseValue;
    }

    public void setAlkalinePhosphataseValue(Double alkalinePhosphataseValue) {
        this.alkalinePhosphataseValue = alkalinePhosphataseValue;
    }

    public String getRefBy() {
        return refBy;
    }

    public void setRefBy(String refBy) {
        this.refBy = refBy;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
