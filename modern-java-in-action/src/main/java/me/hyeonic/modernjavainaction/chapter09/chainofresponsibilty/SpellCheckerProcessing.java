package me.hyeonic.modernjavainaction.chapter09.chainofresponsibilty;

public class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
