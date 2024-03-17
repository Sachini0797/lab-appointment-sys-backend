package com.sachini.labappointmentsys.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 50)
    private String name;
    @Size(max = 40)
    private String designation;
    @Size(max = 40)
    private String consultantTitle;
    private Double consultantFees;
    private Double hospitalFees;
    private String position;
    private String contactNumber;
    private String contactNumber1;
    private String email;
    private String remark;

    public Doctor() {
     }

    public Doctor(String name, String designation, String consultantTitle, Double consultantFees, Double hospitalFees, String position, String contactNumber, String contactNumber1, String email, String remark) {
        this.name = name;
        this.designation = designation;
        this.consultantTitle = consultantTitle;
        this.consultantFees = consultantFees;
        this.hospitalFees = hospitalFees;
        this.position = position;
        this.contactNumber = contactNumber;
        this.contactNumber1 = contactNumber1;
        this.email = email;
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getConsultantTitle() {
        return consultantTitle;
    }

    public void setConsultantTitle(String consultantTitle) {
        this.consultantTitle = consultantTitle;
    }

    public Double getConsultantFees() {
        return consultantFees;
    }

    public void setConsultantFees(Double consultantFees) {
        this.consultantFees = consultantFees;
    }

    public Double getHospitalFees() {
        return hospitalFees;
    }

    public void setHospitalFees(Double hospitalFees) {
        this.hospitalFees = hospitalFees;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber1() {
        return contactNumber1;
    }

    public void setContactNumber1(String contactNumber1) {
        this.contactNumber1 = contactNumber1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
