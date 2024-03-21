package com.sachini.labappointmentsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class FullBloodCount {
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
    private Double haemoglobinValue;
    private Double pcvValue;
    private Double rbcValue;
    private Double mchcValue;
    private Double mchValue;
    private Double mcvValue;
    private Double wbcValue;
    private Double neutrophilsValue;
    private Double lymphocytesValue;
    private Double eosinophilsValue;
    private String monocytesValue;
    private String basophilsValue;
    private String plateletCountValue;
    private String refNo;
    private String refBy;
    private String remarks;

    public FullBloodCount() {}

    public FullBloodCount(Long uid, Long appointmentId, Boolean completed, LocalDateTime createdDate, LocalDateTime sampleCollectedDate, LocalDateTime sampleReceivedDate, LocalDateTime reportAuthorizedDate, Double haemoglobinValue, Double pcvValue, Double rbcValue, Double mchcValue, Double mchValue, Double mcvValue, Double wbcValue, Double neutrophilsValue, Double lymphocytesValue, Double eosinophilsValue, String monocytesValue, String basophilsValue, String plateletCountValue, String refNo, String refBy, String remarks) {
        this.uid = uid;
        this.appointmentId = appointmentId;
        this.completed = completed;
        this.createdDate = createdDate;
        this.sampleCollectedDate = sampleCollectedDate;
        this.sampleReceivedDate = sampleReceivedDate;
        this.reportAuthorizedDate = reportAuthorizedDate;
        this.haemoglobinValue = haemoglobinValue;
        this.pcvValue = pcvValue;
        this.rbcValue = rbcValue;
        this.mchcValue = mchcValue;
        this.mchValue = mchValue;
        this.mcvValue = mcvValue;
        this.wbcValue = wbcValue;
        this.neutrophilsValue = neutrophilsValue;
        this.lymphocytesValue = lymphocytesValue;
        this.eosinophilsValue = eosinophilsValue;
        this.monocytesValue = monocytesValue;
        this.basophilsValue = basophilsValue;
        this.plateletCountValue = plateletCountValue;
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

    public Double getHaemoglobinValue() {
        return haemoglobinValue;
    }

    public void setHaemoglobinValue(Double haemoglobinValue) {
        this.haemoglobinValue = haemoglobinValue;
    }

    public Double getPcvValue() {
        return pcvValue;
    }

    public void setPcvValue(Double pcvValue) {
        this.pcvValue = pcvValue;
    }

    public Double getRbcValue() {
        return rbcValue;
    }

    public void setRbcValue(Double rbcValue) {
        this.rbcValue = rbcValue;
    }

    public Double getMchcValue() {
        return mchcValue;
    }

    public void setMchcValue(Double mchcValue) {
        this.mchcValue = mchcValue;
    }

    public Double getMchValue() {
        return mchValue;
    }

    public void setMchValue(Double mchValue) {
        this.mchValue = mchValue;
    }

    public Double getMcvValue() {
        return mcvValue;
    }

    public void setMcvValue(Double mcvValue) {
        this.mcvValue = mcvValue;
    }

    public Double getWbcValue() {
        return wbcValue;
    }

    public void setWbcValue(Double wbcValue) {
        this.wbcValue = wbcValue;
    }

    public Double getNeutrophilsValue() {
        return neutrophilsValue;
    }

    public void setNeutrophilsValue(Double neutrophilsValue) {
        this.neutrophilsValue = neutrophilsValue;
    }

    public Double getLymphocytesValue() {
        return lymphocytesValue;
    }

    public void setLymphocytesValue(Double lymphocytesValue) {
        this.lymphocytesValue = lymphocytesValue;
    }

    public Double getEosinophilsValue() {
        return eosinophilsValue;
    }

    public void setEosinophilsValue(Double eosinophilsValue) {
        this.eosinophilsValue = eosinophilsValue;
    }

    public String getMonocytesValue() {
        return monocytesValue;
    }

    public void setMonocytesValue(String monocytesValue) {
        this.monocytesValue = monocytesValue;
    }

    public String getBasophilsValue() {
        return basophilsValue;
    }

    public void setBasophilsValue(String basophilsValue) {
        this.basophilsValue = basophilsValue;
    }

    public String getPlateletCountValue() {
        return plateletCountValue;
    }

    public void setPlateletCountValue(String plateletCountValue) {
        this.plateletCountValue = plateletCountValue;
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
