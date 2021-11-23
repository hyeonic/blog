package me.hyeonic.object.chapter10.billing.step07;

import me.hyeonic.object.chapter10.billing.Call;
import me.hyeonic.object.chapter10.billing.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPhone {
    private List<Call> calls;

    public AbstractPhone() {
        this.calls = new ArrayList<>();
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}