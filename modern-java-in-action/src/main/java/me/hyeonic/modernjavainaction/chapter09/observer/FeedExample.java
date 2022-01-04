package me.hyeonic.modernjavainaction.chapter09.observer;

public class FeedExample {

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new MYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObservers("The Queen said her favourite book is Modern Java in Action!");

        feed.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        feed.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wind and news! " + tweet);
            }
        });

        feed.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet more news from London... " + tweet);
            }
        });

        feed.notifyObservers("The Queen said her favourite book is Modern Java in Action!");
    }
}
