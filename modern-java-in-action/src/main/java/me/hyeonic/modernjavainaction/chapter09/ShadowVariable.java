package me.hyeonic.modernjavainaction.chapter09;

public class ShadowVariable {

    public static void main(String[] args) {
        int a = 10;
        Runnable r1 = () -> {
            // int a = 2; 컴파일 에러
            System.out.println(a);
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int a = 2; // 정상 작동
                System.out.println(a);
            }
        };
    }
}
