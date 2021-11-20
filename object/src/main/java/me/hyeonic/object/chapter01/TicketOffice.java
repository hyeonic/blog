package me.hyeonic.object.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    // 기존에 없던 Audience에 대한 의존성 추가 : 트레이드 오프의 결과
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

//    외부에서 TicketOffice의 인스턴스 변수를 제어할 수 없도록 private 으로 제한한다.
    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}