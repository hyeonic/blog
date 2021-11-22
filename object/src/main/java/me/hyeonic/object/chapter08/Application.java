package me.hyeonic.object.chapter08;

import me.hyeonic.object.chapter08.discountcondition.PeriodCondition;
import me.hyeonic.object.chapter08.discountcondition.SequenceCondition;
import me.hyeonic.object.chapter08.discountpolicy.AmountDiscountPolicy;
import me.hyeonic.object.chapter08.discountpolicy.NoneDiscountPolicy;
import me.hyeonic.object.chapter08.discountpolicy.OverlappedDiscountPolicy;
import me.hyeonic.object.chapter08.discountpolicy.PercentDiscountPolicy;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10_000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                )
        );

        // 실행 시점에 할인 정책 변경 가능! 합성은 메시지를 통해 느슨하게 결합된다.
        avatar.changeDiscountPolicy(new NoneDiscountPolicy());

        Movie tiatanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11_000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
                )
        );

        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10_000),
                new NoneDiscountPolicy()
        );

        Movie avengers = new Movie("어벤져스",
                Duration.ofMinutes(180),
                Money.wons(10_000),
                new OverlappedDiscountPolicy(
                        new AmountDiscountPolicy(Money.wons(1000),
                                new SequenceCondition(1),
                                new SequenceCondition(10),
                                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))),
                        new PercentDiscountPolicy(0.1,
                                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                                new SequenceCondition(2),
                                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59)))
                )
        );
    }
}