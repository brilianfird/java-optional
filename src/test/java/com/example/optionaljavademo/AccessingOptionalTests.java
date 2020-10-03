package com.example.optionaljavademo;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class AccessingOptionalTests {
    @Test
    public void get_test() {
        Optional<String> helloWorldOptional = Optional.of("Hello, World");
        assert "Hello, World".equals(helloWorldOptional.get());
    }

    @Test
    public void get_null_test() {
        Optional<String> helloWorldOptional = Optional.empty();
        try {
            helloWorldOptional.get();
        } catch (Exception e) {
            assert e instanceof NoSuchElementException;
        }
    }

    @Test
    public void orElse_test() {
        Optional<String> helloWorldOptional = Optional.of("Hello, World");
        assert "Hello, World".equals(helloWorldOptional.orElse("default"));
    }

    @Test
    public void orELseNull_test() {
        Optional<String> helloWorldOptional = Optional.empty();
        assert "default".equals(helloWorldOptional.orElse("default"));
    }

    @Test
    public void orElseGet_test() {
        Optional<String> helloWorldOptional = Optional.of("Hello, World");
        assert "Hello, World".equals(helloWorldOptional.orElseGet(() ->"default"));
    }

    @Test
    public void orELseGet_Null_test() {
        Optional<String> helloWorldOptional = Optional.empty();
        assert "default".equals(helloWorldOptional.orElseGet(() ->"default"));
    }

    @Test
    public void orElseThrow_test() {
        Optional<String> helloWorldOptional = Optional.of("Hello, World");
        assert "Hello, World".equals(helloWorldOptional.orElseThrow(NullPointerException::new));
    }

    @Test
    public void orELseThrow_Null_test() {
        Optional<String> helloWorldOptional = Optional.empty();
        try {
            helloWorldOptional.orElseThrow(NullPointerException::new);
        } catch (Exception e) {
            assert e instanceof NullPointerException;
        }
    }
}
