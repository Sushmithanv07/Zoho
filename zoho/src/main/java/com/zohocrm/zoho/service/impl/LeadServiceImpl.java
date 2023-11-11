package com.zohocrm.zoho.service.impl;

import com.zohocrm.zoho.entity.Lead;
import com.zohocrm.zoho.exception.LeadExists;
import com.zohocrm.zoho.payload.LeadDto;
import com.zohocrm.zoho.repository.LeadRepository;
import com.zohocrm.zoho.service.LeadService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeadServiceImpl implements LeadService {


    private LeadRepository leadRepo;

    private ModelMapper modelMapper;
    public LeadServiceImpl(LeadRepository leadRepo, ModelMapper modelMapper) {
        this.leadRepo = leadRepo;
        this.modelMapper = modelMapper;
    }



    @Override
    public LeadDto createLead(LeadDto leadDto) {
        boolean emailExists = leadRepo.existsByEmail(leadDto.getEmail());
        boolean mobileExists = leadRepo.existsByMobile(leadDto.getMobile());
        if(emailExists){
            throw new LeadExists("email exist"+leadDto.getEmail());
        }
        if(mobileExists){
            throw new LeadExists("mobile exist"+leadDto.getMobile());
        }
        Lead lead = mapToEntity(leadDto);
        String lid = UUID.randomUUID().toString();
        lead.setLid(lid);

        Lead savedlead = leadRepo.save(lead);
        LeadDto dto = mapToDto(savedlead);
        return dto;
    }

    @Override
    public void deleteLeadById(String lid) {
        Lead lead = leadRepo.findById(lid).orElseThrow(
                () -> new LeadExist("Lead with this is not present -" + lid)
        );
        leadRepo.deleteById(lid);
    }

    Lead mapToEntity(LeadDto leadDto){
        Lead lead = modelMapper.map(leadDto, Lead.class);
        return lead;
    }

    LeadDto mapToDto(Lead lead){
        LeadDto leadDto = modelMapper.map(lead, LeadDto.class);
        return leadDto;
    }
}
