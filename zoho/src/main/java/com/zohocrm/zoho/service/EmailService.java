package com.zohocrm.zoho.service;

import com.zohocrm.zoho.payload.EmailDto;

public interface EmailService {
    public EmailDto sendEmail(EmailDto emailDto);
}
