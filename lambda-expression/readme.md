##Functional Interface
**Functional Interface** is an interface that specifies exactly one abstract method.

The Java library designers for Java 8 have helped you by introducing several new
functional interfaces inside the **java.util.function** package. This is some list:
1. **Predicate**

   The java.util.function.Predicate<T> interface defines an abstract method named
   _test_ that accepts an object of generic type T and returns a boolean


2. **Consumer**

   The java.util.function.Consumer<T> interface defines an abstract method named _accept_
   that takes an object of generic type T and returns no result (void).


3. **Function**

   The java.util.function.Function<T, R> interface defines an abstract method
   named _apply_ that takes an object of generic type T as input and returns an object of
   generic type R. You might use this interface when you need to define a lambda that
   maps information from an input object to an output (for example, extracting the
   weight of an apple or mapping a string to its length).