package me.hyeonic.object.chapter08;

import java.time.LocalDateTime;

// Screening의 책임은 영화를 예매하는 것. 하는 것과 관련된 책임
// 자신이 상영할 영화를 알고 있어야 한다. 아는 것과 관련된 책임
// 상영할 영화(movie), 순번(sequence), 상영 시작 시간(whenScreened)를 인스턴스 변수로 가진다.
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }


    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}