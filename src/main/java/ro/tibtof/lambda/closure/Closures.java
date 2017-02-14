package ro.tibtof.lambda.closure;

import groovy.lang.Closure;
import ro.tibtof.lambda.closure.function.Function3;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Closures {

    private Closures() {
        throw new AssertionError("Should not be instantiated!");
    }

    public static <R> Closure<R> closure(Supplier<R> lambda) {
        return new Closure<R>(lambda) {
            @Override
            public R call() {
                return lambda.get();
            }
        };
    }

    private static <R> Closure<R> buildClosure(Function<Object[], R> lambda) {
        return new Closure<R>(lambda) {
            public R call(Object... args) {
                return lambda.apply(args);
            }
        };
    }

    public static <R, P> Closure<R> closure(Function<P, R> lambda) {
        return buildClosure(args -> lambda.apply((P) args[0]));
    }

    public static <R, P1, P2> Closure<R> closure(BiFunction<P1, P2, R> lambda) {
        return buildClosure(args -> lambda.apply((P1) args[0], (P2) args[1]));
    }

    public static <R, P1, P2, P3> Closure<R> closure(Function3<P1, P2, P3, R> lambda) {
        return buildClosure(args -> lambda.apply((P1) args[0], (P2) args[1], (P3) args[2]));
    }

}
