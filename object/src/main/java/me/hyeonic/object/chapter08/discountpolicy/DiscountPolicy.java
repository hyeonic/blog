package me.hyeonic.object.chapter08.discountpolicy;

import me.hyeonic.object.chapter08.Money;
import me.hyeonic.object.chapter08.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}