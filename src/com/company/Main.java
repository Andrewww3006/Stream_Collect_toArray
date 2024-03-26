package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Collection<Integer> collection = Arrays.asList(1,2,3,4);
        int sum = collection.stream().mapToInt(s -> {
            if (s % 2 == 0) return s;
            else return 0;
        }).sum();
        System.out.println(sum);
    }
}
