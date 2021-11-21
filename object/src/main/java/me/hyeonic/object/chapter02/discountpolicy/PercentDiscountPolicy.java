package me.hyeonic.object.chapter02.discountpolicy;

import me.hyeonic.object.chapter02.Money;
import me.hyeonic.object.chapter02.Screening;
import me.hyeonic.object.chapter02.discountcondition.DiscountCondition;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}