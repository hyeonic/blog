package me.hyeonic.object.chapter02.discountpolicy;

import me.hyeonic.object.chapter02.Money;
import me.hyeonic.object.chapter02.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}