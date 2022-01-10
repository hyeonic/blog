package me.hyeonic.modernjavainaction.chapter10.nestedfunctionorder;

import static me.hyeonic.modernjavainaction.chapter10.nestedfunctionorder.NestedFunctionOrderBuilder.*;

import me.hyeonic.modernjavainaction.chapter10.Order;

public class NestedFunctionOrderExample {

    public static void main(String[] args) {
        Order order = order("BigBank",
            buy(80,
                stock("IBM", on("NYSE")), at(125.00)),
            sell(50,
                stock("GOOGLE", on("NASDAQ")), at(375.00))
        );
    }
}
