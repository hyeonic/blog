package me.hyeonic.chapter07.item42;

public class Crew {

    private final String name;
    private final Course course;

    public Crew() {
        this.name = "unknown";
        this.course = Course.NONE;
    }

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void sendPullRequest() {
        System.out.println(name + " 이/가 리뷰요청을 보냈습니다.");
    }
}
