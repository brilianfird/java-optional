package com.example.optionaljavademo;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ThingToAvoidTests {

    @Test
    public void optionalAsParameter_test() {
        try {
            isPhoneNumberPresent(null);
        } catch (Exception e) {
            assert e instanceof NullPointerException;
        }
    }

    public boolean isPhoneNumberPresent(Optional<String> phoneNumber) {
        return phoneNumber.isPresent();
    }

    @Test
    public void getWithoutIsPresent_test() {
        Optional<String> helloWorldOptional = Optional.ofNullable(null);
        if (helloWorldOptional.isPresent()) {
            System.out.println(helloWorldOptional.get());
        }
    }

    @Test
    public void getWithoutIsPresent_error_test() {
        Optional<String> helloWorldOptional = Optional.ofNullable(null);
        try {
            System.out.println(helloWorldOptional.get());
        } catch (Exception e) {
            assert e instanceof NoSuchElementException;
        }
    }
}
