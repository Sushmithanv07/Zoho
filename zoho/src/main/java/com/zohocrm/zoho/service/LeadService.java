package com.zohocrm.zoho.service;

import com.zohocrm.zoho.payload.LeadDto;

import java.util.List;

public interface LeadService {
    LeadDto createLead(LeadDto leadDto);

    void deleteLeadById(String lid);

    List<LeadDto> getAllLeads();
}
