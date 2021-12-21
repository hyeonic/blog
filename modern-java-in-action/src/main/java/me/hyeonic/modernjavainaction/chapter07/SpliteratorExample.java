package me.hyeonic.modernjavainaction.chapter07;

public class SpliteratorExample {

    public static void main(String[] args) {
        final String SENTENCE =
            "Nel    mezzo del cammin di nostra vita " +
            "mi ritrovai in una selva oscura " +
            "ch     la dritta via era smarrita ";

        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
    }

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) counter++;
                lastSpace = false;
            }
        }
        return counter;
    }
}
