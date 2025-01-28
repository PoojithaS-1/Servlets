package com.xworkz.exceldb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Student1 {
    @Id
    private int rollNo;

    private String name;

    // Getters and setters
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

