package me.hyeonic.modernjavainaction.chapter10.lambdaorder;

import me.hyeonic.modernjavainaction.chapter10.Stock;

public class StockBuilder {
    public Stock stock = new Stock();

    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }

    public void market(String market) {
        stock.setMarket(market);
    }
}
