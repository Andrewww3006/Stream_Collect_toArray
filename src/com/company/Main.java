package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Collection<Integer> collection = Arrays.asList(1,2,3,4);
        int sum = collection.stream().mapToInt(s -> {
            if (s % 2 == 1) return s;
            else return 0;
        }).sum();
        System.out.println(sum);
        int sum2 = collection.stream().filter(s->s%2==1).mapToInt(s->s).sum();
        System.out.println(sum2);
        Double avr = collection.stream().collect(Collectors.averagingInt(s->s-1));

        System.out.println(avr);

        IntSummaryStatistics statistics = collection.stream().collect(Collectors.summarizingInt(s->s+3));
        System.out.println(statistics);
        Map<Boolean, List<Integer>> part = collection.stream().collect(Collectors.partitioningBy(s->s%2==1));
        System.out.println(part);

        Collection<String> stringCollection = Arrays.asList("a1","b2","c3","a1");
        Object[] array = stringCollection.stream().distinct().toArray();
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        stringCollection.stream().distinct().collect(Collectors.toList()).forEach(System.out::print);
        List<String> stringList = stringCollection.stream().distinct().collect(Collectors.toList());
        System.out.println();
        System.out.println(stringList);

        String[] stringArray;
        stringArray = stringCollection.stream().distinct().map(String::toUpperCase).toArray(String[]::new);
        System.out.println(Arrays.asList(stringArray));

        String testString = stringCollection.stream().collect(Collectors.joining(":", "<b>", "</b>"));
        System.out.println(testString);
        Map<String, String> testMap = stringCollection.stream().distinct().collect(Collectors.toMap(s->s.substring(0,1),s->s.substring(1,2)));
        System.out.println(testMap);
        Map<String, List<String>> testMap2 = stringCollection.stream().collect(Collectors.groupingBy((s->s.substring(0,1))));
        System.out.println(testMap2);

        Map<String, String> testMap3 = stringCollection.stream().collect(Collectors.groupingBy(s->s.substring(0,1),Collectors.mapping(p->p.substring(1,2),Collectors.joining(":"))));
        System.out.println(testMap3);
    }

}
