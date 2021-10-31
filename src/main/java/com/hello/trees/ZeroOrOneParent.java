package com.hello.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroOrOneParent {

    public static void main(String[] args) {
        int[][] parentChildPairs = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {8, 9}
        };

        List<List<Integer>> returnList = findParents(parentChildPairs);

       returnList.get(0).stream().forEach(System.out::println);
        System.out.println("~~~~");
        returnList.get(1).stream().forEach(System.out::println);
        // parent, child

    }

    // Time Complexity: O(n) n - num of ind.
    // Space Complexity: O(n)
    public static List<List<Integer>> findParents(int[][] pairs){
        Map<Integer, Integer> numberOfParents = new HashMap<>();

        for(int i = 0; i < pairs.length; i++){
            int child = pairs[i][1];
            int parent = pairs[i][0];

            if (numberOfParents.containsKey(child))
                numberOfParents.put(child, numberOfParents.get(child) + 1);
            else
                numberOfParents.put(child, 1);

            if (!numberOfParents.containsKey(parent))
                numberOfParents.put(parent, 0);

        }

        List<Integer> zeroParents = new ArrayList<>();
        List<Integer> oneParent = new ArrayList<>();

        numberOfParents.forEach((key, value) -> {
            if(value == 0)
                zeroParents.add(key);
            if(value == 1)
                oneParent.add(key);
        });

        List<List<Integer>> returnList = new ArrayList<>();

        returnList.add(zeroParents);
        returnList.add(oneParent);

        return returnList;


    }
}