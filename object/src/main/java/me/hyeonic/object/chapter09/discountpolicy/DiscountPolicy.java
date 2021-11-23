package me.hyeonic.object.chapter09.discountpolicy;

import me.hyeonic.object.chapter09.Money;
import me.hyeonic.object.chapter09.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}