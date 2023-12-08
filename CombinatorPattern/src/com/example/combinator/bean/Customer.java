package com.example.combinator.bean;

import java.time.LocalDate;

public class Customer {
    private String customerName;
    private String customerEmail;
    private String customerPhonerNumber;
    private LocalDate customerDateOfBirth;
    
    public Customer(String customerName, String customerEmail, String customerPhoneNumber, LocalDate customerDateOfBirth) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhonerNumber = customerPhoneNumber;
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhonerNumber() {
        return customerPhonerNumber;
    }

    public void setCustomerPhonerNumber(String customerPhonerNumber) {
        this.customerPhonerNumber = customerPhonerNumber;
    }

    public LocalDate getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(LocalDate customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

}