package com.zohocrm.zoho.service.impl;

import com.zohocrm.zoho.entity.Contact;
import com.zohocrm.zoho.entity.Lead;
import com.zohocrm.zoho.exception.LeadExists;
import com.zohocrm.zoho.payload.ContactDto;
import com.zohocrm.zoho.repository.ContactRepository;
import com.zohocrm.zoho.repository.LeadRepository;
import com.zohocrm.zoho.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private LeadRepository leadRepo;
    @Autowired
    private ContactRepository contactRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ContactDto createContact(String leadId) {
        Lead lead = leadRepo.findById(leadId).orElseThrow(
                ()-> new LeadExists("Lead with this id does not exists")
        );
        Contact contact = convertLeadToContact(lead);
        String cid = UUID.randomUUID().toString();
        contact.setCid(cid);
        Contact savedContact = contactRepo.save(contact);

        if(savedContact.getCid()!=null){
            leadRepo.deleteById(lead.getLid());
        }
       return mapToDto(savedContact);

    }

    ContactDto mapToDto(Contact contact){
      return  modelMapper.map(contact, ContactDto.class);
    }
    Contact convertLeadToContact(Lead lead){
        Contact contact = modelMapper.map(lead, Contact.class);
        return contact;
    }
}
