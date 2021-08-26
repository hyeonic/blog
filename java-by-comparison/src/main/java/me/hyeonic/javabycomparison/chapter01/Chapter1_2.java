package me.hyeonic.javabycomparison.chapter01;

public class Chapter1_2 {

    public static void main(String[] args) {

        User user = new User();
        Youtube youtube = new Youtube();
        youtube.setPremium(true);
        user.setYoutube(youtube);

        if (user.getYoutube().isPremium()) {
            System.out.println("프리미엄 사용자 입니다.");
        } else if (user.getYoutube().isNotPremium()) {
            System.out.println("프리미엄 사용자가 아닙니다.");
        }
    }
}