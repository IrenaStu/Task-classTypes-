package org.example;

import java.util.function.Predicate;
//Use og generic types
@FunctionalInterface
public interface Validator<T> extends Predicate<T> {
    @Override
    boolean test( T value);

    default  Validator<T> and (Validator<T>other) {
        return value -> this.test(value) && other.test(value);
    }

    default Validator <T> or (Validator<T> other){
        return value -> this.test(value)|| other.test(value);
    }
}
