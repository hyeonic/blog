package me.hyeonic.object.chapter09.discountpolicy;

import me.hyeonic.object.chapter09.Money;
import me.hyeonic.object.chapter09.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}