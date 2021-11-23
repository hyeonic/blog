package me.hyeonic.object.chapter09;

import me.hyeonic.object.chapter09.discountcondition.PeriodCondition;
import me.hyeonic.object.chapter09.discountcondition.SequenceCondition;
import me.hyeonic.object.chapter09.discountpolicy.AmountDiscountPolicy;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

// 객체 생성의 책임을 가진다.
public class Factory {
    public Movie createAvatarMovie() {
        return new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10_000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                )
        );
    }
}