package me.hyeonic.modernjavainaction.chapter09.chainofresponsibilty;

public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
