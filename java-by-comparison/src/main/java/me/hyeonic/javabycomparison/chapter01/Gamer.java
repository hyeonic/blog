package me.hyeonic.javabycomparison.chapter01;

public class Gamer {

    private String name;
    private int age;
    private Desktop desktop;
    private Mouse mouse;

//    public boolean isValid() {
//        if (age < 12 || name == null || name.trim().isEmpty()) {
//            return false;
//        } else {
//            return true;
//        }
//    }

//    public boolean isValid() {
//        return age >= 12 && name != null && !name.trim().isEmpty();
//    }

//    public boolean isValid() {
//        boolean isValidAge = age >= 12;
//        boolean isValidName = name != null && !name.trim().isEmpty();
//        return isValidAge && isValidName;
//    }

//    public boolean isValid() {
//        return desktop != null &&
//                mouse != null &&
//                age >= 12 &&
//                name != null &&
//                !name.trim().isEmpty();
//    }

    public boolean isValid() {
        boolean hasComputer = hasDesktop() && hasMouse();
        boolean isValidAge = age >= 12;
        boolean isValidName = name != null && !name.trim().isEmpty();
        return hasComputer && isValidAge && isValidName;
    }

    private boolean hasDesktop() {
        return desktop != null;
    }

    private boolean hasMouse() {
        return mouse != null;
    }
}