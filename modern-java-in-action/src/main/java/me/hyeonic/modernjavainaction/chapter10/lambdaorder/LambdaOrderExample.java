package me.hyeonic.modernjavainaction.chapter10.lambdaorder;

import static me.hyeonic.modernjavainaction.chapter10.lambdaorder.LambdaOrderBuilder.*;

import me.hyeonic.modernjavainaction.chapter10.Order;

public class LambdaOrderExample {

    public static void main(String[] args) {
        Order order = order(o -> {
            o.buy(t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });
            o.sell(t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });
    }
}
