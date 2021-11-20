package org.example.abstract_criteria;

import org.example.Apple;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppleInventoryAbstractTest {
    AppleInventoryAbstract anAbstract = new AppleInventoryAbstract();

    @Test
    void filterApples() {
        var apples = List.of(
                new Apple(67, Apple.Color.GREEN),
                new Apple(50, Apple.Color.RED),
                new Apple(120, Apple.Color.RED),
                new Apple(200, Apple.Color.GREEN)
        );

        var actual = anAbstract.filterApples(apples, new AppleRedAndHeavyPredicate());
        var actual2 = anAbstract.filterApples(apples, new AppleGreenPredicate());


        assertEquals(List.of(new Apple(120, Apple.Color.RED)),actual);
        assertEquals(List.of(
                new Apple(67, Apple.Color.GREEN),
                new Apple(200, Apple.Color.GREEN)),
                actual2);
    }
}