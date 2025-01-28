package com.xworkz.dbexcel;

// JPA modules
import javax.persistence.*;


// Entity class representing the database table
@Entity
class Student {
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

