package me.hyeonic.javabasic.string;

public class Application {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(System.identityHashCode(str));
        str += "world";
        System.out.println(System.identityHashCode(str));

        System.out.println(plusString());
    }

    private static String plusString() {
        String number = "";
        for (int i = 0; i < 100000; i++) {
            number += i;
        }
        return number;
    }

    private static String plusStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}