package com.hello.string;

import java.util.*;

public class UniqChar {

    public static void main(String[] args) {
        System.out.println(uniqChar2("aaccddzebe"));
    }

    public static int uniqChar(String str) {
        char[] charArr = str.toCharArray();
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : charArr) {
            int count = 1;
            if (countMap.get(c) != null) {
                count = countMap.get(c) + 1;
            }
            countMap.put(c, count);
        }

        Optional<Map.Entry<Character, Integer>> entry = countMap.entrySet().stream().filter(e -> e.getValue() == 1).findFirst();
        if (entry.isPresent()) {
            return str.indexOf(entry.get().getKey());
        } else {
            return -1;
        }
    }

    public static int uniqChar2(String s) {
        char[] charArr = s.toCharArray();

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < charArr.length; i++) {
            Integer count = countMap.get(charArr[i]);
            if (count == null) {
                countMap.put(charArr[i], 1);
            } else {
                countMap.put(charArr[i], count + 1);
            }
        }

        for (Map.Entry<Character,Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }
}
