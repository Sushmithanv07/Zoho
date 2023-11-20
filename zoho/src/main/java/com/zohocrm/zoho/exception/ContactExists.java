package com.zohocrm.zoho.exception;

public class ContactExists extends RuntimeException {
    public ContactExists(String message) {
        super(message);
    }
}
