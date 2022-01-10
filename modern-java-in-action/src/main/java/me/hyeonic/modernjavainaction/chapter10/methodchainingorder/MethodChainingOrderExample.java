package me.hyeonic.modernjavainaction.chapter10.methodchainingorder;

import me.hyeonic.modernjavainaction.chapter10.Order;

public class MethodChainingOrderExample {

    public static void main(String[] args) {
        Order order = MethodChainingOrderBuilder.forCustomer("BigBank")
            .buy(80)
            .stock("IBM")
            .on("NYSE")
            .at(125.00)
            .sell(50)
            .stock("GOOGLE")
            .on("NASDAQ")
            .at(375.00)
            .end();
    }
}
