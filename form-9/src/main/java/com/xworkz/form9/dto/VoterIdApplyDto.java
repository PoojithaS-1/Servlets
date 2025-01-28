package com.xworkz.form9.dto;

import lombok.Data;

@Data
public class VoterIdApplyDto {
    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
}