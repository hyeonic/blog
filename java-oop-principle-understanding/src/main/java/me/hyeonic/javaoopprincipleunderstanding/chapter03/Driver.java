package me.hyeonic.javaoopprincipleunderstanding.chapter03;

public class Driver {
    public static void main(String[] args) {
        날수있는 날라리1 = new 박쥐();
        날라리1.fly();

        날수있는 날라리2 = new 참새();
        날라리2.fly();

        헤엄칠수있는[] 맥주병들 = new 헤엄칠수있는[2];

        맥주병들[0] = new 고래();
        맥주병들[1] = new 펭귄();

        for (헤엄칠수있는 맥주병 : 맥주병들) {
            맥주병.swim();
        }

        Penguin pororo = new Penguin();

        pororo.name = "뽀로로";
        pororo.habitat = "남극";

        pororo.showName();
        pororo.showName("츠보람보");
        pororo.showHabitat();

        Animal pingu = new Penguin();

        pingu.name = "핑구";
        // pingu.habitat = "EBS";

        pingu.showName();
//        pingu.showHabitat();

//        Penguin happyfeet = new Animal();
    }
}