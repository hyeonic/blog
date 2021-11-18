package me.hyeonic.modernjavainaction.chapter04;

public class TriFunctionDriver {

    public static void main(String[] args) {

//        TriFunction<Integer, Integer, Integer, Color> colorFactory1 = (red, green, blue) -> new Color(red, green, blue);
        TriFunction<Integer, Integer, Integer, Color> colorFactory1 = Color::new;

//        TriFunction<Integer, Integer, Integer, Color> colorFactory2 = (red, green, blue) -> Color.create(red, green, blue);
        TriFunction<Integer, Integer, Integer, Color> colorFactory2 = Color::create;

        Color color1 = colorFactory1.apply(1, 1, 2);
        Color color2 = colorFactory2.apply(1, 1, 2);
    }
}