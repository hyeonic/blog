package me.hyeonic.object.chapter01;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    /*
    Theater가 Audience와 TicketSeller뿐만 아니라 Audience 소유자의 Bag과 TicketSeller가 근무하는 TicketOffice까지 마음대로 접근한다.
    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
    */

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}