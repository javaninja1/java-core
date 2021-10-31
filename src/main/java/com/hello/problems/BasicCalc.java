package com.hello.problems;

import java.util.function.Consumer;

public class BasicCalc {

    public static  void main(String args[]) {
        Consumer<String> log = e -> System.out.println(e);
        log.accept("" + eval("13 - 2 + 4"));
    }

    private static long eval(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int sign = 1;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                String num = "" + arr[i];
                while (i + 1 < s.length() && Character.isDigit(arr[i + 1])) {
                    num += arr[++i];
                }
                int numInt = Integer.parseInt(num);
                result += numInt * sign;
            } else if (arr[i] == '+') {
                sign = +1;
            } else if (arr[i] == '-') {
                sign = -1;
            } else if ( arr[i] == ' ' ) {
                //skip
            }
        }
        return result;
    }

}
