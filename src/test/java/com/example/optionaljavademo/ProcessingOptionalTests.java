package com.example.optionaljavademo;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessingOptionalTests {

    @Test
    public void processingOptional_map_test() {
        Optional<String> stringOptional = Optional.of("Hello, World")
                .map(a -> a + ", Hello");

        assert stringOptional.isPresent();
        assert "Hello, World, Hello".equals(stringOptional.get());
    }

    @Test
    public void processingOptional_map_empty_test() {
        Optional<String> stringOptional = Optional.of("Hello, World")
                .map(a -> null);

        assert !stringOptional.isPresent();
    }

    @Test
    public void processingOptional_map_empty_notProcessed_test() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Optional<String> stringOptional = Optional.of("Hello, World")
                .map(a -> null)
                .map(a -> {
                    atomicBoolean.set(true);
                    return "won't be processed";
                });

        assert !stringOptional.isPresent();
        assert atomicBoolean.get() == false;
    }

    @Test
    public void processingOptional_flatmap_test() {
        Optional<String> stringOptional = Optional.of("Hello, World")
                .flatMap(this::getString);

        assert "Hello, World, Hello".equals(stringOptional.get());
    }

    @Test
    public void processingOptional_flatmap_randomString_test() {
        Optional<String> stringOptional = Optional.of(UUID.randomUUID().toString())
                .flatMap(this::getString);

        assert !stringOptional.isPresent();
    }

    public Optional<String> getString(String s) {
        if ("Hello, World".equals(s)) {
            return Optional.of("Hello, World, Hello");
        }
        return Optional.empty();
    }

    @Test
    public void processingOptional_filter_test() {
        Optional<String> stringOptional = Optional.of("Hello, World")
                .filter(helloWorldString -> "Hello, World".equals(helloWorldString))
                .map(helloWorldString -> helloWorldString + ", Hello");

        assert "Hello, World, Hello".equals(stringOptional.get());
    }

    @Test
    public void processingOptional_filter_randomString_test() {
        Optional<String> stringOptional = Optional.of(UUID.randomUUID().toString())
                .filter(helloWorldString -> "Hello, World".equals(helloWorldString))
                .map(helloWorldString -> helloWorldString + ", Hello");

        assert !stringOptional.isPresent();
    }

    @Test
    public void processingOptional_ifPresent_test() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Optional.of("Hello, World")
            .ifPresent(helloWorldString -> atomicBoolean.set(true));
        assert atomicBoolean.get();
    }

    @Test
    public void processingOptional_ifPresent_empty_test() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Optional.empty()
                .ifPresent(helloWorldString -> atomicBoolean.set(true));
        assert !atomicBoolean.get();
    }
}
