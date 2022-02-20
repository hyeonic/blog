package me.hyeonic.javabasic.stringsplit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a,b,c,d,e");
        list.add("a,b,c,d,e,");
        list.add("a,  ,b");
        list.add(", , , , ");
        list.add(",,,,");
        list.add("a");

        for (String s : list) {
            System.out.println("나눌 문자열: " + s);
            System.out.println("limt이  0일 때: " + Arrays.toString(s.split(",")));
            System.out.println("limt이 -1일 때: " + Arrays.toString(s.split(",", -1)));
            System.out.println();
        }
    }
}