package com.arkarmoe.twiliolookupdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ValidateController {
    @Autowired
    private PhoneNumberValidator phoneNumberValidator;

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestBody Person person) {
        System.out.println("person: " + person.toString());
        boolean isValid = phoneNumberValidator.isValid(person.getPhoneNumber());
        System.out.println("isValid :" + isValid);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }
}
