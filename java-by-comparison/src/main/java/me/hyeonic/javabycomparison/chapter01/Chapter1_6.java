package me.hyeonic.javabycomparison.chapter01;

public class Chapter1_6 {

    public static void main(String[] args) {

        Color color = Color.RED;

        switch (color) {
            case RED:
                System.out.println("red");
            case BLUE:
                System.out.println("blue");
                break;
            case YELLOW:
                System.out.println("yellow");
                break;
            case GREEN:
                System.out.println("green");
                break;
        }
    }
}