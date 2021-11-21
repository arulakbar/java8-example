package org.example;

import java.io.BufferedReader;

/*
    a functional interface which take BufferedReader as argument
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws Exception;
}
