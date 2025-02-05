package com.xworkz.form18.dto;
import lombok.Data;

@Data
public class StudIdDto {
    private Integer studId;
    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
    private String instituteName;
    private String courseName;
    private Integer academicYear;
}