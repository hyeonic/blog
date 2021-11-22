package me.hyeonic.object.chapter08.discountpolicy;

import me.hyeonic.object.chapter08.Money;
import me.hyeonic.object.chapter08.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappedDiscountPolicy extends DefaultDiscountPolicy {
    private List<DiscountPolicy> discountPolicies;

    public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
        this. discountPolicies = new ArrayList<>(Arrays.asList(discountPolicies));
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return null;
    }
}