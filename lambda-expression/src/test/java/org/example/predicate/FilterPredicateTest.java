package org.example.predicate;

import org.example.Apple;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class FilterPredicateTest {

    FilterPredicate filterPredicate = new FilterPredicate();

    @Test
    void filterNonEmptyStringList() {
        var strings = List.of("One", "Two", "Three");

        Predicate<String> nonEmptyString = s -> !s.isEmpty();

        var actual = filterPredicate.filter(strings, nonEmptyString);

        assertEquals(List.of("One","Two","Three"),actual);
    }

    @Test
    void filterEmptyStringList() {
        var strings = List.of("One", "Two", "");

        Predicate<String> nonEmptyString = s -> !s.isEmpty();

        var actual = filterPredicate.filter(strings, nonEmptyString);

        assertEquals(List.of("One","Two"),actual);
    }

    @Test
    void filterApple() {
        var apples = List.of(
                new Apple(50, Apple.Color.RED),
                new Apple(100, Apple.Color.GREEN),
                new Apple(120, Apple.Color.RED));

        // apple with red color
        Predicate<Apple> redApple = apple -> apple.getColor().equals(Apple.Color.RED);

        // apple no red color
        Predicate<Apple> notRedApples = redApple.negate();

        // Combine red apple with weight > 50
        Predicate<Apple> redAndWeightApple = redApple.and(apple -> apple.getWeight() > 50);

        // Combine three chain. apples that are red and heavy or green
        Predicate<Apple> redAndHeavyAppleOrGreen = redAndWeightApple.
                or(apple -> apple.getColor().equals(Apple.Color.GREEN));

        var redAppleList = filterPredicate.filter(apples, redApple);
        var notRedAppleList = filterPredicate.filter(apples, notRedApples);
        var threeChain = filterPredicate.filter(apples, redAndHeavyAppleOrGreen);

        System.out.println(redApple);
        System.out.println(notRedAppleList);
        System.out.println(threeChain);
    }
}