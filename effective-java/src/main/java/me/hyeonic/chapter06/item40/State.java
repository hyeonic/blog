package me.hyeonic.chapter06.item40;

import me.hyeonic.chapter06.item40.card.Card;
import me.hyeonic.chapter06.item40.card.Cards;

public interface State {

    State draw(Card card);

    State stay();

    boolean isRunning();

    boolean isFinished();

    Cards cards();

    double earningRate(State state);
}