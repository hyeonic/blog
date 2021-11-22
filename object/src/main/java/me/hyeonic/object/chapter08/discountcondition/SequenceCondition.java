package me.hyeonic.object.chapter08.discountcondition;

import me.hyeonic.object.chapter08.Screening;

// 순번 조건
public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}