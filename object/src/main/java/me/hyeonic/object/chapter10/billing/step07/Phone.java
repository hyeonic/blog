package me.hyeonic.object.chapter10.billing.step07;

import me.hyeonic.object.chapter10.billing.Call;
import me.hyeonic.object.chapter10.billing.Money;

import java.time.Duration;

public class Phone extends AbstractPhone {
    private Money amount;
    private Duration seconds;

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }


    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}