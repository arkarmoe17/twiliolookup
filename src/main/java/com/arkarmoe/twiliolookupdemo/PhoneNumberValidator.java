package com.arkarmoe.twiliolookupdemo;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.lookups.v1.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class PhoneNumberValidator {

    @Value("${TWILIO_ACCOUNT_SID}")
    private String twilioAccountSid;

    @Value("${TWILIO_AUTH_TOKEN}")
    private String twilioAuthToken;


    public PhoneNumberValidator() {
    }

    @PostConstruct
    public void init(){
        System.out.println("---- twilio running. ----");
        Twilio.init(twilioAccountSid, twilioAuthToken);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("---- twilio stopping. ----");
        Twilio.destroy();
    }

    public boolean isValid(String value) {
        value = value.replaceAll("[\\s()-]", "");
        if ("".equals(value)) {
            return false;
        }
        try {
            PhoneNumber.fetcher(new com.twilio.type.PhoneNumber(value)).fetch();
            return true;
        } catch (ApiException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }
}
