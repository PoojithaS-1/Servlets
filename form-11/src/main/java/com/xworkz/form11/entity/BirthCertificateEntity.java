package com.xworkz.form11.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "birthCertificate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirthCertificateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String childName;
    private String dob;
    private String placeOfBirth;
    private String fatherName;
    private String motherName;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
}