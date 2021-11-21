package me.hyeonic.object.chapter02.discountpolicy;

import me.hyeonic.object.chapter02.Money;
import me.hyeonic.object.chapter02.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}