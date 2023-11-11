package com.zohocrm.zoho.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="leads")
public class Lead {
    @Id
    private String lid;
    @Column(name="first_name", nullable=false)
    private String firstname;
    @Column(name="last_name", nullable=false)
    private String lastname;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="mobile", nullable=false, unique=true)
    private long mobile;
    @Column(name="lead_type", nullable=false)
    private String leadType;
    @Column(name="address")
    private String address;
    @Column(name="designation")
    private String designation;
    @Column(name="company")
    private String company;
    @Column(name="note")
    private String note;

}
