package com.example.combinator.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import com.example.combinator.bean.Customer;

import static com.example.combinator.service.CustomerRegistrationValidator.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {
    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
    
    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getCustomerEmail().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID; 
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getCustomerPhonerNumber().startsWith("+91") ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(LocalDate.now(), customer.getCustomerDateOfBirth()).getYears() > 18 ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator combinedFunction) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? combinedFunction.apply(customer) : result;
        };
    }

}