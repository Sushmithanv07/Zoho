package com.zohocrm.zoho.service;

import com.zohocrm.zoho.payload.LeadDto;

public interface LeadService {
    LeadDto createLead(LeadDto leadDto);

    void deleteLeadById(String lid);
}
