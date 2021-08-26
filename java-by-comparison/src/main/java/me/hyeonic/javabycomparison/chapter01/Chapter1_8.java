package me.hyeonic.javabycomparison.chapter01;

public class Chapter1_8 {

    public static void main(String[] args) {

        User user = new User();
        Youtube youtube = new Youtube();
        youtube.setPremium(true);
        user.setYoutube(youtube);

        if (user.getYoutube().isPremium()) {
            // ...
        }

        if (!user.getYoutube().isPremium()) {
            // ...
        }
    }
}