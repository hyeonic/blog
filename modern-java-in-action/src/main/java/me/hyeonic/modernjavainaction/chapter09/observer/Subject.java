package me.hyeonic.modernjavainaction.chapter09.observer;

public interface Subject {

    void registerObserver(Observer observer);
    void notifyObservers(String tweet);
}
