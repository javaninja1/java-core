package com.hello.trees;
import java.util.*;

public class ZeroOrOne {


//    findNodesWithZeroAndOneParents(parentChildPairs) => [
//            [1, 2, 4, 15, 30],   // Individuals with zero parents
//            [5, 7, 9, 16]        // Individuals with exactly one parent
//            ]

        public static void main(String[] argv) {
            int[][] parentChildPairs = new int[][] {
                    {3, 6}, {1, 3}, {2, 3}, {5, 6}, {15, 12}, {5, 7},
                    {4, 5}, {4, 9}, {9, 12}, {30, 16}
            };

            List<List<Integer>> resultLists = processTree(parentChildPairs);

            System.out.println("~~~~~~~~");

            for (Integer val : resultLists.get(0)) {
                System.out.println(val);
            }
            System.out.println("~~~~~~~~");
            for (Integer val : resultLists.get(1)) {
                System.out.println(val);
            }



            //traverse up the tree and find number of terminal nodes

            //if number of terminal nodes == 1
            //store in result1

            //if number of terminal nodes == 0
            //result2

            //print both results

        }

        private static List<List<Integer>> processTree(int[][] parentChildPairs) {
            Set<Integer> all = new HashSet<>();

            for (int i=0; i< parentChildPairs.length; i++) {
                int[] pair = parentChildPairs[i];
                all.add(pair[0]);
                all.add(pair[1]);
            }

            //all.forEach(System.out::println);

            //n + n * unique  + uniquecount

            Map<Integer, Integer> countMap = new HashMap<>();

            for(Integer val : all) {
                int count = 0;
                for (int i=0; i< parentChildPairs.length; i++) {
                    int[] pair = parentChildPairs[i];
                    int secondElement = pair[1];
                    if (secondElement == val) {
                        count++;
                    }
                }
                countMap.put(val, count);
            }

            List<Integer> resultZero = new ArrayList<>();
            List<Integer> resultOne = new ArrayList<>();

            for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 0) {
                    resultZero.add(entry.getKey());
                }
                if (entry.getValue() == 1) {
                    resultOne.add(entry.getKey());
                }
            }

            List<List<Integer>> resultLists = new ArrayList<>();
            resultLists.add(resultZero);
            resultLists.add(resultOne);
            return resultLists;

        }
}

