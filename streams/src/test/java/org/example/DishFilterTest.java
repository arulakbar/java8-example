package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class DishFilterTest {
    DishService service = new DishService();

    @Test
    void filterWithPredicate() {
        var vegetarianMenu = service.getMenu()
                .stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        System.out.println(vegetarianMenu);
    }

    @Test
    void filteringWithUniqueElements() {
        List.of(1, 2, 1, 3, 3, 2, 4)
                .stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(System.out::println);

    }
}
