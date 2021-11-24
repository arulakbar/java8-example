package org.example.consumer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerExampleTest {

    ConsumerExample consumerExample = new ConsumerExample();

    @Test
    void forEach() {
        var strings = List.of("One", "Two", "Three");

        Consumer<String> toInteger = System.out::println;

        consumerExample.forEach(strings, toInteger);
    }
}