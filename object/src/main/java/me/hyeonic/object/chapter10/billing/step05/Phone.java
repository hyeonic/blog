package me.hyeonic.object.chapter10.billing.step05;

import me.hyeonic.object.chapter10.billing.Call;
import me.hyeonic.object.chapter10.billing.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls;

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
        this.calls = new ArrayList<>();
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result;
    }
}