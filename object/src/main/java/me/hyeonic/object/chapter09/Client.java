package me.hyeonic.object.chapter09;

public class Client {
    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    // 오직 사용과 관련된 책임만 가지고 있다.
    public Money getAvatarFee() {
        Movie avatar = factory.createAvatarMovie();
        return avatar.getFee();
    }

    /*
    생성과 사용의 책임을 모두 가지고 있다.
    public Money getAvatarFee() {
        // 생성의 책임
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

        // 사용의 책임
        return avatar.getFee();
    }
     */
}