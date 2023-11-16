package com.zohocrm.zoho.service.impl;

import com.zohocrm.zoho.entity.Email;
import com.zohocrm.zoho.entity.Lead;
import com.zohocrm.zoho.exception.LeadExists;
import com.zohocrm.zoho.payload.EmailDto;
import com.zohocrm.zoho.repository.EmailRepository;
import com.zohocrm.zoho.repository.LeadRepository;
import com.zohocrm.zoho.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private LeadRepository leadRepo;

    @Autowired
    private EmailRepository emailRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmailDto sendEmail(EmailDto emailDto) {
        Lead lead = leadRepo.findByEmail(emailDto.getTo()).orElseThrow(
                () -> new LeadExists("Email Id not registered - " + emailDto.getTo())
        );

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getTo());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getMessage());

        javaMailSender.send(message);
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
