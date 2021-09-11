package com.hello.simple;

public class RevNum {

    public static void main(String args[]) {
        RevNum obj = new RevNum();
        System.out.println(obj.rev(-2147483648));
        System.out.println(obj.reverse(-2147483648));
        System.out.println(obj.isPalindrome(121));
    }

    // -123 != palindrome(321)
    public boolean isPalindrome(int x) {
      if(x < 0) return false;
      int y = x;
      int rev = 0;
      while (x != 0) {
          int digit = x%10; //3  | 2 | 1
          x /= 10; //12 | 1
          rev = rev * 10 + digit; // 0*0 + 3 | 30 + 2 | 320 + 1
      }
      return (y == rev);
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
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
