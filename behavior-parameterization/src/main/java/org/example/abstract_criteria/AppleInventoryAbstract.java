package org.example.abstract_criteria;

import org.example.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleInventoryAbstract {
    public List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
