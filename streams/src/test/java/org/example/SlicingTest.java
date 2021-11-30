package org.example;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SlicingTest {
    DishService service = new DishService();

    List<Dish> sortByCalories = service.getMenu()
            .stream().sorted(Comparator.comparing(Dish::getCalories))
            .collect(Collectors.toList());

    @Test
    void slicingWithTakeWhilePredicate() {
        /*
        The downside of using the filter operation here is that you need to iterate through the
        whole stream and the predicate is applied to each element. Instead, you could stop
        once you found a dish that is greater than (or equal to) 320 calories.
         */


        // takeWhile
        // it stops once it has found an element that fails to match
        sortByCalories.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .forEach(System.out::println);
    }

    @Test
    void sliceWithDropWhilePredicate() {

        // dropWhile
        // it has found an element greater than 320
        sortByCalories.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .forEach(System.out::println);
    }
}
