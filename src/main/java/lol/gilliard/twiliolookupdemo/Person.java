package lol.gilliard.twiliolookupdemo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Person {

    @NotNull
    @NotBlank(message="Please enter your name")
    private String name;

    @NotNull
    @ValidPhoneNumber(message="Please enter a valid phone number")
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PersonForm{" +
            "name='" + name + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            '}';
    }
}

