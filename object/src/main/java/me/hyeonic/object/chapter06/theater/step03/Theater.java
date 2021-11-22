package me.hyeonic.object.chapter06.theater.step03;

// 디미터 법칙 위반
// Audience, Bag, Ticket 에 대한 의존성으로 높은 결합도를 가지고 있다.
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        // Audience가 ticket을 살 수 있도록 '구매하라' 메시지 전달.
        // 하지만 setTicket이라는 오퍼레이션명은 클라이언트에게 와닿지 않는 이름이다.
        ticketSeller.sellTo(audience);
    }
}