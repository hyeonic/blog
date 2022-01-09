package me.hyeonic.modernjavainaction.chapter09.chainofresponsibilty;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibilityExample {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy??");
        System.out.println(result); // From Raoul, Mario and Alan: Aren't lambdas really sexy??

        UnaryOperator<String> headerProcessing = text -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = text -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        // String result = pipeline.apply("Aren't labdas really sexy??");
    }
}
