package com.xworkz.form20.dto;
import lombok.Data;

@Data
public class GymApplyDto {
    private Integer id;
    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
    private String membershipPlan;
}
