package me.hyeonic.modernjavainaction.chapter10.lambdaorder;

import java.util.function.Consumer;

import me.hyeonic.modernjavainaction.chapter10.Trade;

public class TradeBuilder {
    public Trade trade = new Trade();

    public void quantity(int quantity) {
        trade.setQuantity(quantity);
    }

    public void price(double price) {
        trade.setPrice(price);
    }

    public void stock(Consumer<StockBuilder> consumer) {
        StockBuilder builder = new StockBuilder();
        consumer.accept(builder);
        trade.setStock(builder.stock);
    }
}
