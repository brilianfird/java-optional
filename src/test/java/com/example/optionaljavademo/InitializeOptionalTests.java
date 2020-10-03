package com.example.optionaljavademo;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class InitializeOptionalTests {

    @Test
    public void initializeOptional_optionalOf() {
        Optional<String> helloWorldOptional = Optional.of("Hello, world");
        assert helloWorldOptional.isPresent();
        assert "Hello, world".equals(helloWorldOptional.get());
    }

    @Test
    public void initializeOptional_optionalOf_null() {
        try {
            Optional.of(null);
        } catch (Exception e) {
            assert e instanceof NullPointerException;
        }
    }

    @Test
    public void initializeOptional_optionalEmpty() {
        Optional<String> helloWorldOptional = Optional.empty();
        assert !helloWorldOptional.isPresent();
    }

    @Test
    public void initializeOptional_optionalOfNullable() {
        Optional<String> helloWorldOptional = Optional.ofNullable("Hello, world");
        assert helloWorldOptional.isPresent();
        assert "Hello, world".equals(helloWorldOptional.get());
    }

    @Test
    public void initializeOptional_optionalOfNullable_null() {
        Optional<String> helloWorldOptional = Optional.ofNullable(null);
        assert !helloWorldOptional.isPresent();
        try {
            helloWorldOptional.get();
        } catch (Exception e) {
            assert e instanceof NoSuchElementException;
        }
    }

}
