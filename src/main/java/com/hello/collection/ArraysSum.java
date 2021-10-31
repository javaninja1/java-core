package com.hello.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysSum {

    public static void main(String[] args) {
        int[][] arr= {{1,2}, {3,4},{13,4},{33,4}};
        sum(arr);
        System.out.println("~~~~~~~~~~~~~~");
        sumArr(arr);
    }

    static void sumArr(int [][] arr) {
        List<List<Integer>> listOfLists = Arrays.stream(arr).map(e ->
                 Arrays.stream(e).boxed().collect(Collectors.toList())).collect(Collectors.toList());

        listOfLists.parallelStream().mapToInt(
                e -> e.stream().reduce(Integer::sum).orElse(0)
        ).forEach(System.out::println);

    }

    static void sum (int[][] ar ) {
        List<List<Integer>> listOfLists = new ArrayList<>();

        Map<Integer,List<Integer>> mapList = new HashMap<>();

        for (int i=0; i< ar.length; i++) {
            List<Integer> intList = Arrays.stream(ar[i]).boxed().collect(Collectors.toList());
            listOfLists.add(intList);
        }


        listOfLists.parallelStream()
                .mapToInt( e -> e.stream().reduce(Integer::sum).orElse(0))
                .forEach(System.out::println);
        //return Arrays.stream(ar).boxed().mapToInt(i -> i.intValue()).reduce(Integer::sum).orElse(0);
    }
}
