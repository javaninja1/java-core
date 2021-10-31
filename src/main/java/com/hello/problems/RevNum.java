package com.hello.problems;

public class RevNum {

    public static void main(String args[]) {
        RevNum obj = new RevNum();
        System.out.println(obj.rev(-2147483648));
        System.out.println(obj.reverse(-2147483648));

        System.out.println(obj.reverse(2789781));
        System.out.println(obj.reverse(100000000));

        System.out.println(obj.isPalindrome(121));
        System.out.println(obj.isPalindrome(-121));
    }

    // -123 != palindrome(321)
    public boolean isPalindrome(long x) {
      if(x < 0) return false;
      return ( x==  reverse(x));
    }

    //if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
    //if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
    long reverse(long x) {
        long rev =0;
        while (x != 0) {
            long pop = x%10;
            x = x/10;
            rev = rev *10 + pop;
        }
        return rev;
    }

    public int reverse2(int x) {
        boolean negative = x<0;
        x = Math.abs(x);
        String str = "" + x;
        byte[] input  = str.getBytes();
        byte[] output = new byte[input.length];
        for (int i=0; i< input.length; i++) {
            output[i] = input[input.length -i -1];
        }
        String reverse = new String(output);
        int rev = 0 ;
        try {
            rev = Integer.parseInt(reverse);
            if (negative)
                rev *= -1;
        } catch (Exception ex) {
            System.out.println (ex.getMessage());
        }
        return rev;
    }

    public int rev(int x) {
        boolean negative = (x<0);
        x = Math.abs(x);
        int rev = 0;
        StringBuilder newNum = new StringBuilder();
        while (x>9) {
            newNum.append(x%10);
            x = x/10;
        }
        newNum.append(x);
        int result =  0;
        try {
            result = Integer.parseInt(newNum.toString());
            result = (negative)? result*-1: result;
        } catch (Exception ex) {
            result= 0;
        }
        return result;
    }
}
