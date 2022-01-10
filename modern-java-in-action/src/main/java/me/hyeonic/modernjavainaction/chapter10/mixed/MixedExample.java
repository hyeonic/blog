package me.hyeonic.modernjavainaction.chapter10.mixed;

import static me.hyeonic.modernjavainaction.chapter10.mixed.MixedBuilder.*;

import me.hyeonic.modernjavainaction.chapter10.Order;

public class MixedExample {

    public static void main(String[] args) {
        Order order = forCustomer("BigBank",
            buy(t -> t.quantity(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)),
            sell(t -> t.quantity(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(125.00))
        );
    }
}
