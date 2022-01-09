package me.hyeonic.modernjavainaction.chapter09;

public class RefactoringExample {

    public static void main(String[] args) {
        RefactoringExample refactoringExample = new RefactoringExample();

        refactoringExample.run();
    }

    public void run() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "익명 클래스 자신";
            }
        };

        r1.run();

        Runnable r2 = () -> {
            System.out.println(this);
        };

        r2.run();
    }

    @Override
    public String toString() {
        return "람다를 감싸는 클래스";
    }
}
