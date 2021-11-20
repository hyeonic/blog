package me.hyeonic.object.chapter01;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    /*
    public Bag getBag() {
        return bag;
    }
     */

    /*
    Bag은 Audience에 의해 제어된다. Audience는 Bag안에 ticket과 amount에 접근하고 있다.
    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
     */

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}