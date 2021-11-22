package me.hyeonic.object.chapter06.theater.step01;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(Long amount, Invitation invitation, Ticket ticket) {
        this.amount = amount;
        this.invitation = invitation;
        this.ticket = ticket;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long sell) {
        this.amount += amount;
    }
}