#Stream
_Stream_ are update to the Java API that let you manipulate collections of data in declarative way
(you express query rather than code an ad hoc implementation for it).
```java
List<String> lowCaloriesDishesName = 
    menu.stream()
        .filter(m -> m.getCalories() < 400) // select dish that are below 400 calories
        .sorted(Comparing(Dish::getCalories)) // sort them by calories
        .map(Dish::getName) // extracts the name of these dishes
        .collect(toList()); // stores all names in List
```

##Stream Operation
1. ###Intermediate Operations

   _Intermediate operations_  return another stream as the return type. 

    What’s important is that intermediate operations don’t perform any processing until a terminal operation is invoked on the stream pipeline—they’re lazy.

    - _filter, map, and limit_ can be connected together to form a pipeline

2. ###Terminal Operations
   _Terminal operations_ produce a result from a stream pipeline. A result is any nonstream value such as a List, an Integer, or even void

   - _collect_ causes the pipeline to be executed and closes it