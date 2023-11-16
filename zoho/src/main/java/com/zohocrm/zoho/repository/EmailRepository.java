package com.zohocrm.zoho.repository;

import com.zohocrm.zoho.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, String> {
}
