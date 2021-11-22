package me.hyeonic.object.chapter08.discountpolicy;

import me.hyeonic.object.chapter08.Money;
import me.hyeonic.object.chapter08.Screening;
import me.hyeonic.object.chapter08.discountcondition.DiscountCondition;

// 금액 할인 정책
public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}