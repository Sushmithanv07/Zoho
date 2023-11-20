package com.zohocrm.zoho.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContactDto {

    private String cid;
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
