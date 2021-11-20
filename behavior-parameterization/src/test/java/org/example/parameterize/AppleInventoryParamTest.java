package org.example.parameterize;

import org.example.Apple;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppleInventoryParamTest {
    AppleInventoryParam appleInventoryParam = new AppleInventoryParam();

    @Test
    void filterAppleByColor() {
        var apples = List.of(
                new Apple(67, Apple.Color.GREEN),
                new Apple(120, Apple.Color.RED),
                new Apple(200, Apple.Color.GREEN)
        );

        var actual = appleInventoryParam.filterAppleByColor(apples, Apple.Color.RED);

        assertEquals(List.of(new Apple(120, Apple.Color.RED)),actual);
    }
}