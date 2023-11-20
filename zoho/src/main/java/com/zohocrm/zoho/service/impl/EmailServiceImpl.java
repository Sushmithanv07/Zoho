package com.zohocrm.zoho.service.impl;


import com.zohocrm.zoho.entity.Email;
import com.zohocrm.zoho.entity.Lead;
import com.zohocrm.zoho.exception.ContactExists;
import com.zohocrm.zoho.payload.EmailDto;
import com.zohocrm.zoho.repository.ContactRepository;
import com.zohocrm.zoho.repository.EmailRepository;
import com.zohocrm.zoho.repository.LeadRepository;
import com.zohocrm.zoho.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    private LeadRepository leadRepo;
    private EmailRepository emailRepo;
    private ContactRepository contactRepo;
    private ModelMapper modelMapper;

    public EmailServiceImpl(LeadRepository leadRepo, EmailRepository emailRepo, ContactRepository contactRepo, ModelMapper modelMapper) {
        this.leadRepo = leadRepo;
        this.emailRepo = emailRepo;
        this.contactRepo = contactRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmailDto sendEmail(EmailDto emailDto) {
        Lead lead = leadRepo.findByEmail(emailDto.getTo()).orElseThrow(
                () -> new ContactExists("Email Id not registered - " + emailDto.getTo())
        );

//        Contact contact = contactRepo.findByEmail(emailDto.getTo()).orElseThrow(
//                () -> new LeadExists("Email Id not registered - " + emailDto.getTo())
//        );

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getTo());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getMessage());

        javaMailSender.send(message);
        System.out.println(message.getTo());
        Email email = mapToEtity(emailDto);
        String eid = UUID.randomUUID().toString();
        email.setEid(eid);

        Email sentEmail = emailRepo.save(email);
        return mapToDto(sentEmail);

    }
    Email mapToEtity(EmailDto emailDto){
        Email email = modelMapper.map(emailDto, Email.class);
        return email;
    }
    EmailDto mapToDto(Email email){
        EmailDto dto = modelMapper.map(email, EmailDto.class);
        return dto;
    }
}
