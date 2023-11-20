package com.zohocrm.zoho;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

@SpringBootApplication
public class ZohoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZohoApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSender javaMailSender = new JavaMailSender() {
			@Override
			public void send(SimpleMailMessage simpleMessage) throws MailException {

			}

			@Override
			public void send(SimpleMailMessage... simpleMessages) throws MailException {

			}

			@Override
			public MimeMessage createMimeMessage() {
				return null;
			}

			@Override
			public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
				return null;
			}

			@Override
			public void send(MimeMessage mimeMessage) throws MailException {

			}

			@Override
			public void send(MimeMessage... mimeMessages) throws MailException {

			}

			@Override
			public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

			}

			@Override
			public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

			}
		};
		return javaMailSender;

	}

}
