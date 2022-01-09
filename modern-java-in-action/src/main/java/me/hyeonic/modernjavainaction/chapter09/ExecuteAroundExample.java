package me.hyeonic.modernjavainaction.chapter09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundExample {

    public static void main(String[] args) throws IOException {
        String oneLine = processFile(b -> b.readLine());
        String twoLines = processFile(b -> b.readLine() + b.readLine());
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
