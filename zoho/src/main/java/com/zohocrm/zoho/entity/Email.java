package com.zohocrm.zoho.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="emails")
public class Email {
    @Id
        private String eid;
        private String to;
        private String subject;
        private String message;
    }

