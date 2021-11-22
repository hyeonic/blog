package me.hyeonic.object.chapter06.theater.step03;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }

    // Audience가 ticket을 가지도록 만드는 것.
    // setTicket -> sellTo 변경
    // 의도가 드러나는 퍼블릭 인터페이스
    public void sellTo(Audience audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }
}