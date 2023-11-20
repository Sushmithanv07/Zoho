package com.zohocrm.zoho.controller;

import com.zohocrm.zoho.payload.ContactDto;
import com.zohocrm.zoho.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
  private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    //  http://localhost:8080/api/contacts/leadId

    @PostMapping("{leadId}")
    public ResponseEntity<ContactDto> createContact(@PathVariable String leadId){
        ContactDto dto = contactService.createContact(leadId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
}
}
