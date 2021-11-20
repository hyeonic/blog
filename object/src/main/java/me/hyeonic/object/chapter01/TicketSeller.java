package me.hyeonic.object.chapter01;

public class TicketSeller {
    private TicketOffice ticketOffice; // 오직 TicketSeller에 의해서만 접근 가능

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    /*
    외부에서 ticketOffice에 접근할 수 없도록 제한한다.
    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
     */

    /*
    여전히 관람객의 가방에 접근하고 있다. 자신의 가방을 열지 못하도록 제한해야 한다.
    public void sellTo(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
     */

    /*
    TicketOffice의 내부에 직접적으로 접근하고 있다.
    public void sellTo(Audience audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }
     */

    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}