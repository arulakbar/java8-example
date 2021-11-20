package org.example.abstract_criteria;

import org.example.Apple;

import java.util.ArrayList;
import java.util.List;

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
}
