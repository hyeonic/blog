package me.hyeonic.datastructure.array;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        Node[] nodes = {new Node("node1"), new Node("node2")};

        int[] numbers = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));

        int[] cloneNumbers = numbers.clone();
        System.out.println(Arrays.toString(cloneNumbers));

        int[] copyOfNumbers = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(copyOfNumbers));

        int[] copyOfRangeNumbers = Arrays.copyOfRange(numbers, 0, numbers.length);
        System.out.println(Arrays.toString(copyOfRangeNumbers));

        int[] systemArraycopyNumbers = new int[numbers.length];
        System.arraycopy(numbers, 0, systemArraycopyNumbers, 0, numbers.length);
        System.out.println(Arrays.toString(systemArraycopyNumbers));
    }
}
