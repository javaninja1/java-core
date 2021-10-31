package com.hello.problems;

import java.util.Arrays;

public class SubsetSum2 {

//    // Returns true if there exists a subsequence of `A[0…n]` with the given sum
//    public static boolean subsetSum(int[] array, int n, int sum) {
//        // return true if the sum becomes 0 (subset found)
//        if (sum == 0) {
//            return true;
//        }
//
//        // base case: no items left, or sum becomes negative
//        if (n < 0 || sum < 0) {
//            return false;
//        }
//
//        // Case 1. Include the current item `A[n]` in the subset and recur
//        // for the remaining items `n-1` with the remaining total `sum-A[n]`
//        boolean include = subsetSum(array, n - 1, sum - array[n]);
//
//        // Case 2. Exclude the current item `A[n]` from the subset and recur for
//        // the remaining items `n-1`
//        boolean exclude = subsetSum(array, n - 1, sum);
//
//        // return true if we can get subset by including or excluding the
//        // current item
//        return include || exclude;
//    }

    public static boolean subset(int[] array, int startIndex, int sum) {
        System.out.println(Arrays.toString(array) + ":" + startIndex + ":" + sum);
        if (sum == 0) return true;
        if (array.length - startIndex == 1) {
            if (array[0] == sum)
                return true;
            else
                return false;
        }
        boolean result1 = subset(array, startIndex + 1, sum - array[startIndex]);
        boolean result2 = subset(array, startIndex + 1, sum);
        return result1 || result2;
    }

    // Subset Sum Problem
    public static void main(String[] args) {
        int[] array = {1,2,3};

        System.out.println("result:" + subset(array, 1, 14));

    }
}


