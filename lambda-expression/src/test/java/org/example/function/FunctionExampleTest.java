package org.example.function;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FunctionExampleTest {

    FunctionExample functionExample = new FunctionExample();
    @Test
    void map() {
        var strings = List.of("One", "Two", "Three");

        Function<String,Integer> len = String::length;

        var list = functionExample.map(strings, len);

        assertEquals(List.of(3,3,5),list);
    }
}