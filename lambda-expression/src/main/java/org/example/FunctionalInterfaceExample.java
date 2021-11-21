package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class FunctionalInterfaceExample {


    /*
    Use lambda with behavior parameterization
    1. Create Functional Interface which is match the signature
        ex: Take Bufferedreader that may throw exception and return String
    2. Create method which take the functional interface argument
    3. Pass lambda
     */

    public static void main(String[] args) throws Exception {
        /*
            pass lambda
         */
        String oneLine = process(BufferedReader::readLine);
        String twoLine = process(br -> br.readLine() + br.readLine());

        System.out.println(oneLine);
        System.out.println(twoLine);
    }

    /*
        a method with functional interface as argument
     */
    public static String process(BufferedReaderProcessor br) throws Exception{
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("lambda-expression/file.txt"))) {
            return br.process(bufferedReader);
        }
    }
}
