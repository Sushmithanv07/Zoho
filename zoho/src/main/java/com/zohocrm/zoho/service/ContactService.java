package com.zohocrm.zoho.service;

import com.zohocrm.zoho.payload.ContactDto;
import com.zohocrm.zoho.payload.LeadDto;

import java.util.List;

public interface ContactService {
    ContactDto createContact(String leadId);
}
