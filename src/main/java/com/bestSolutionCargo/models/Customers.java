package com.bestSolutionCargo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customers {

    @Id
    @GeneratedValue
    private Long Id;
    private String FName, LName, Gender, MartialStatus;
    private Date DoB;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMartialStatus() {
        return MartialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        MartialStatus = martialStatus;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }
}
