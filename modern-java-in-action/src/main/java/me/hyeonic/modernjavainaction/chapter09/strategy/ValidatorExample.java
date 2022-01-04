package me.hyeonic.modernjavainaction.chapter09.strategy;

public class ValidatorExample {

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        System.out.println(numericValidator.validate("aaaa")); // false

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        System.out.println(lowerCaseValidator.validate("bbbb")); // true

        Validator functionalNumericValidator = new Validator(s -> s.matches("\\d+"));
        System.out.println(functionalNumericValidator.validate("aaaa")); // false

        Validator functionalLowerCaseValidator = new Validator(s -> s.matches("[a-z]+"));
        System.out.println(functionalLowerCaseValidator.validate("bbbb")); // true
    }
}
