package org.example.abstract_criteria;

import org.example.Apple;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppleInventoryAbstractTest {
    AppleInventoryAbstract anAbstract = new AppleInventoryAbstract();
    List<Apple> apples = List.of(
            new Apple(67, Apple.Color.GREEN),
            new Apple(50, Apple.Color.RED),
            new Apple(120, Apple.Color.RED),
            new Apple(200, Apple.Color.GREEN)
    );

    @Test
    void filterApples() {

        var actual = anAbstract.filterApples(apples, new AppleRedAndHeavyPredicate());
        var actual2 = anAbstract.filterApples(apples, new AppleGreenPredicate());

        assertEquals(List.of(new Apple(120, Apple.Color.RED)),actual);
        assertEquals(List.of(
                new Apple(67, Apple.Color.GREEN),
                new Apple(200, Apple.Color.GREEN)),
                actual2);
    }

    @Test
    void filterAppleWithAnonymousClass() {

        var redApples = anAbstract.filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals(Apple.Color.RED);
            }
        });
        assertEquals(List.of(
                new Apple(50, Apple.Color.RED),
                new Apple(120, Apple.Color.RED)), redApples);
    }

    @Test
    void filterAppleWithLambda() {
        var actual = anAbstract.filterApples(this.apples, apple -> apple.getWeight() > 100);
        assertEquals(List.of(
                new Apple(120, Apple.Color.RED),
                new Apple(200, Apple.Color.GREEN)), actual);
    }

    @Test
    void filterWithGenericType() {
        List<Integer> numbers = List.of(1,2,3,4,5);

        var actual = anAbstract.filter(numbers, number -> number % 2 == 0);
        var actual2 = anAbstract.filter(apples, apple -> apple.getColor().equals(Apple.Color.RED));

        assertEquals(List.of(2,4),actual);
        assertEquals(List.of(
                new Apple(50, Apple.Color.RED),
                new Apple(120, Apple.Color.RED)), actual2);


    }
}