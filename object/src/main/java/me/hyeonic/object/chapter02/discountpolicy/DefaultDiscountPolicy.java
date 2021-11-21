package me.hyeonic.object.chapter02.discountpolicy;

import me.hyeonic.object.chapter02.discountcondition.DiscountCondition;
import me.hyeonic.object.chapter02.Money;
import me.hyeonic.object.chapter02.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 할인 정책
// 부모 클래스에 기본적인 알고리즘 흐름을 구혀하고 중간에 필요한 처리를 자식 클래스에게 위임하는 template method pattern
public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private List<DiscountCondition> conditions;

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = new ArrayList<>(Arrays.asList(conditions));
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Screening screening);
}