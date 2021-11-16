package me.hyeonic.javaoopprincipleunderstanding.chapter03;

public class 동물 implements 울수있는 {
    String myClass;

    동물() {
        myClass = "동물";
    }

    void showMe() {
        System.out.println(myClass);
    }

    @Override
    public void 울어보세요() {
        System.out.println("울음소리");
    }
}