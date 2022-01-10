package me.hyeonic.modernjavainaction.chapter10.methodreferencewithfunction;

import java.util.function.DoubleUnaryOperator;

import me.hyeonic.modernjavainaction.chapter10.Order;

public class TaxCalculator {
    public DoubleUnaryOperator taxFunction = d -> d;

    public TaxCalculator with(DoubleUnaryOperator f) {
        taxFunction = taxFunction.andThen(f);
        return this;
    }

    public double calculate(Order order) {
        return taxFunction.applyAsDouble(order.getValue());
    }
}
