package com.sachini.labappointmentsys.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lab_test")
public class LabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 40)
    private String testName;

    @Size(max = 10)
    private String testShortName;

     private Integer testNo;


    private Double finalAmount;

     private Double amount;

    @Size(max = 50)
    private String remarks;

     private Double percentage;

     private Double discount;

    public LabTest() {
    }

    public LabTest(String testName, String testShortName, Integer testNo, Double finalAmount, Double amount, String remarks, Double percentage, Double discount) {
        this.testName = testName;
        this.testShortName = testShortName;
        this.testNo = testNo;
        this.finalAmount = finalAmount;
        this.amount = amount;
        this.remarks = remarks;
        this.percentage = percentage;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestShortName() {
        return testShortName;
    }

    public void setTestShortName(String testShortName) {
        this.testShortName = testShortName;
    }

    public Integer getTestNo() {
        return testNo;
    }

    public void setTestNo(Integer testNo) {
        this.testNo = testNo;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
