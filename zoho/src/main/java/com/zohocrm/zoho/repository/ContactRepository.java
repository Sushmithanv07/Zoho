package com.zohocrm.zoho.repository;

import com.zohocrm.zoho.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {
}
