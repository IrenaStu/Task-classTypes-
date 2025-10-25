package org.example;
import java.util.function.Predicate;

// Functional interface use
public class EmailFormatChecker  implements Predicate<String>{
    @Override
    public boolean test(String email) {
        return email != null && email.contains("@");
    }
}
