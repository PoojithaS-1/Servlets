package com.xworkz.form18.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "studId")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQuery(name = "deleteById" , query = "delete from StudIdEntity ent where ent.studId=:studId")
@NamedQuery(name = "getApplicantById" , query = "select ent from StudIdEntity ent where ent.studId=:studId")


public class StudIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studId;
    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String instituteName;
    private String courseName;
    private String academicYear;
}