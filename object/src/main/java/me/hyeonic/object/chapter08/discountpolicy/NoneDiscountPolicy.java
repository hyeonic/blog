package me.hyeonic.object.chapter08.discountpolicy;

import me.hyeonic.object.chapter08.Money;
import me.hyeonic.object.chapter08.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}