package com.hello.string;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

public class RevString {

    public static void main2(String args[]) {
        String str = null;
        Optional<String> op = Optional.ofNullable(str);
        System.out.println(op.orElse("bbb"));
    }

    public static void main(String[] args) {

      Consumer<String> log = (e) ->  System.out.println(e);

      String str = "abcd";
      RevString revString = new RevString();
      log.accept("rev::" + revString.getReverseWord(str));
      log.accept("rev2::" + revString.revStr(str));

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

    private  String revStr(String str) {
        char[] rev  = new char[str.length()];
        for (int i=0; i< str.length(); i++) {
            rev[i] = str.charAt(str.length()-i-1);
        }
        return new String(rev);
    }

    private static String reverseString(String str) {
        char[] rev = new char[str.length()];
        for (int i=0; i<str.length(); i++) {
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
