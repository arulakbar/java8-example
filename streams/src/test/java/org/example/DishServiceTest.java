package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DishServiceTest {

    DishService service = new DishService();

    @Test
    void threeHighCalorieDish() {
        var menu = service.getMenu()
                .stream()   // get a stream from menu
                .filter(dish -> dish.getCalories() > 300)   // create a pipeline of operation: first filter high-calories
                .map(Dish::getName) // get name of the dishes
                .limit(3) // select only the first three
                .collect(Collectors.toList());  // store the result in another list

        System.out.println(menu);

    }

    @Test
    void traversableOnlyOnce() {
        // You can consume only once
        var stream = service.getMenu()
                .stream().map(Dish::getName);

        stream.forEach(System.out::println);

        stream.forEach(System.out::println);

    }

}