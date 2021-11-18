package me.hyeonic.modernjavainaction.chapter04;

public interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);
}