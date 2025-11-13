package hr.tvz.entity;

import java.util.Collection;

public sealed interface Evaluatable permits User, Lesson, Fact {

    int evaluate();

    default <T> int evaluate(Collection<T> collection) {
        int sum = 0;
        for (T t : collection) {
            sum += ((Evaluatable) t).evaluate();
        }
        return sum;
    };
}
