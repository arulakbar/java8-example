package org.example.consumer;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public <T> void forEach(List<T>list, Consumer<T> c){
        for (T t : list) {
            c.accept(t);
        }
    }
}
