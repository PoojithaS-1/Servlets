package com.xworkz.form19.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "banking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQuery(name = "deleteById" , query = "delete from BankingApplyEntity ent where ent.id=:id")
@NamedQuery(name = "getApplicantById" , query = "select ent from BankingApplyEntity ent where ent.id=:id")

public class BankingApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
    private String accountType;
    private Double initialDeposit;
}
