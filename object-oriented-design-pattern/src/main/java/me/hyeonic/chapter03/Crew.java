package me.hyeonic.chapter03;

public class Crew extends Person implements Studiable {

    @Override
    public void introduce() {
        System.out.println("크루 입니다.");
    }

    @Override
    public void study() {
        System.out.println("호호의 스터디에 참여 중입니다.");
    }
}
