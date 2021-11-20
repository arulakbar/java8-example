package org.example.parameterize;

import org.example.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleInventoryParam {
    public List<Apple> filterAppleByColor(List<Apple> apples, Apple.Color color){
        List<Apple> appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(color)){
                appleList.add(apple);
            }
        }
        return appleList;
    }
}
