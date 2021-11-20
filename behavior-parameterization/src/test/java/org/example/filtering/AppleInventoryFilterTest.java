package org.example.filtering;

import org.example.Apple;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppleInventoryFilterTest {
    AppleInventory appleInventory = new AppleInventory();

    @Test
    void filterGreenApples() {
        var apples = List.of(
                new Apple(67, Apple.Color.GREEN),
                new Apple(120, Apple.Color.RED),
                new Apple(200, Apple.Color.GREEN)
        );

        var actual = appleInventory.filterGreenApples(apples);

        assertEquals(List.of(new Apple(67, Apple.Color.GREEN),
                new Apple(200, Apple.Color.GREEN)), actual);

    }
}