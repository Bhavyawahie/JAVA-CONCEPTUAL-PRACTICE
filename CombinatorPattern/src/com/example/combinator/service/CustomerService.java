package com.example.combinator.service;

import java.time.LocalDate;
import java.time.Period;

import com.example.combinator.bean.Customer;

public class CustomerService {
    private boolean isEmailValid(String email) {
        return email.contains("@");
    } 

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+91");
    }

    private boolean isAdult(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears() > 18;
    }

    public boolean isValid(Customer customer) {
        return isEmailValid(customer.getCustomerEmail()) && isPhoneNumberValid(customer.getCustomerPhonerNumber()) && isAdult(customer.getCustomerDateOfBirth());
    }
}
