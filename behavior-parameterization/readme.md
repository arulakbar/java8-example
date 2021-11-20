## **Passing code with behavior parameterization**
**Behavior parameterization** is a software development pattern that lets you handle frequent requirement changes.

1. **Filtering by abstract criteria**
    - create an interface Predicate:
   
    ```java
        public interface ApplePredicate{
            boolean test(Apple apple);
        }    
    ```
    - declare multiple implementation of ApplePredicate:
    ```java
        public class AppleGreenPredicate implements ApplePredicate{
            public boolean test(Apple apple){
                return apple.getColor.equals(GREEN);
            }        
        }     
    ```
   ```java
        public class AppleHeavyPredicate implements ApplePredicate{
            public boolean test(Apple apple){
                return apple.getWeight > 100;
            }        
        }     
    ```
   - implement method:
   ```java
    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
            for(Apple apple: inventory) {
                if(p.test(apple)) {
                    result.add(apple);
                }
            }
        return result;
   }
    ```
   - calling that method:
    ```java
    var greenAppleList = filterApples(apples, new AppleGreenPredicate());
    var heavyAppleList = filterApples(apples, new AppleHeavyPredicate());
    ```
****
****
2. **Using anonymous class**
```java
    List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
        public boolean test(Apple apple){
            return RED.equals(apple.getColor());
        }
    });
```
****
****
3. **Using Lambda**
```java
    List<Apple> result =
        filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));
```

4. **Replace Apple class with Generic type**
```java
    public interface Predicate<T>{
        boolean test(T t);    
    }
```
