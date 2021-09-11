package com.hello.simple;

import java.util.Arrays;
import java.util.function.Consumer;

public class RevString {

    public static void main(String[] args) {

      Consumer<String> consumer = (String name) -> { System.out.println(name);};
      String str = "abcd";

      RevString revString = new RevString();
      consumerDemo(consumer, "rev::" + revString.getReverseWord(str));

      System.out.println("anagram::" + isAnagram("abcdefg","fgadbce"));
	  //subStrings("assadqweqwea", "aws");
    }

    private static void consumerDemo(Consumer<String> consumer, String arg) {
        consumer.accept(arg);
    }

    public  String getReverseWord(String word){
        if(word == null || word.isEmpty()){
            return word;
        }
        return word.charAt(word.length()- 1) + getReverseWord(word.substring(0, word.length() - 1));
    }

    private static boolean isAnagram(String str1 , String str2) {
        char[] charStr1  = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();
        Arrays.sort(charStr1);
        Arrays.sort(charStr2);
        System.out.println(new String(charStr1));
        System.out.println(new String(charStr2));
        return Arrays.equals(charStr1, charStr2 );
    }

    private static String reverseString(String str) {
        char[] rev = new char[str.length()];
        for (int i=0; i<str.length(); i++) {
            System.out.println(str.charAt(i));
            rev[str.length()-(i+1)] = str.charAt(i);
        }
        return new String(rev);
    }

    //find substrings that contain the characters
    private static String[] subStrings(String str, String substringChars) {
        char[] chars = substringChars.toCharArray();
        int len = chars.length;

        for (char c : chars) {
            System.out.println(c);
        }
        return new String[]{""};
    }
}
