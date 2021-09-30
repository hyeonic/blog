package me.hyeonic.modernjavainaction.chapter03;

import me.hyeonic.modernjavainaction.chapter02.Color;

public class Apple {

    private Color color;
    private int weight;
    private String country;

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}