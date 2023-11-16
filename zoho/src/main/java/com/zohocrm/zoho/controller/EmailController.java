package com.zohocrm.zoho.controller;

import com.zohocrm.zoho.payload.EmailDto;
import com.zohocrm.zoho.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<EmailDto> sendEmail(@RequestBody EmailDto emailDto){
        EmailDto dto = emailService.sendEmail(emailDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}