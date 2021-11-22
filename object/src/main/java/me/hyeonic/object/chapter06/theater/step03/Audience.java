package me.hyeonic.object.chapter06.theater.step03;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    // 이전 코드에서는 hasInvitation 메서드를 통하여 초대권을 가지고 있는지 검증한다. 디미터 법칙 위반
    // setTicket 구현을 bag으로 이동하고 메시지를 전달한다.
    // 하지만 setTicket이라는 오퍼레이션명은 적절하지 못하다. 즉 의도가 잘 드러나지 않는다.
    // setTicket -> buy 변경
    // 의도가 드러나는 퍼블릭 인터페이스
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}