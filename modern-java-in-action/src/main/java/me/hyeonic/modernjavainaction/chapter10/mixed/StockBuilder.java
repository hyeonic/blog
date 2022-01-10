package me.hyeonic.modernjavainaction.chapter10.mixed;

import me.hyeonic.modernjavainaction.chapter10.Stock;
import me.hyeonic.modernjavainaction.chapter10.Trade;

public class StockBuilder {
    private final TradeBuilder builder;
    private final Trade trade;
    private final Stock stock = new Stock();

    public StockBuilder(TradeBuilder builder, Trade trade, String symbol) {
        this.builder = builder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public TradeBuilder on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return builder;
    }
}
