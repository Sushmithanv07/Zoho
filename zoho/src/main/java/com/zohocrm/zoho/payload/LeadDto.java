package com.zohocrm.zoho.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class LeadDto {

    private String lid;
    private String firstname;
    private String lastname;
    private String email;
    private long mobile;
    private String leadType;
    private String address;
    private String designation;
    private String company;
    private String note;

}
