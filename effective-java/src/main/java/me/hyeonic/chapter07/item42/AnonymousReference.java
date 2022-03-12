package me.hyeonic.chapter07.item42;

public class AnonymousReference {

    public static void main(String[] args) {
        AnonymousReference anonymousReference = new AnonymousReference();
        anonymousReference.run();
    }

    public void run() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "Runnable";
            }
        };
        runnable.run();
    }

    @Override
    public String toString() {
        return "AnonymousReference";
    }
}
