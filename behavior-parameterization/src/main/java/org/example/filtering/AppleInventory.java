package org.example.filtering;

import org.example.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleInventory {
    public List<Apple> filterGreenApples(List<Apple> apples){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(Apple.Color.GREEN)){
                result.add(apple);
            }
        }
        return result;
    }
}
