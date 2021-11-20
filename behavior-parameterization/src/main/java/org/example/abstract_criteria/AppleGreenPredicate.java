package org.example.abstract_criteria;

import org.example.Apple;

public class AppleGreenPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Apple.Color.GREEN);
    }
}
