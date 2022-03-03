package me.hyeonic.chapter03;

public class Application {

    public static void main(String[] args) {
        Person person = new Crew();
        person.introduce();

        Studiable studiable = new Crew();

        Workable workable = new Developer();
        workable.work();
    }
}
