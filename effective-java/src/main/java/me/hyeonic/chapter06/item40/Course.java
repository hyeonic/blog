package me.hyeonic.chapter06.item40;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    NONE("미정"),
    ;

    private final String name;

    Course(String name) {
        this.name = name;
    }
}
