package com.leetcode;

/**
 * Created by mengtian on 2017/11/12
 * <p>
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class Atoi {
    public static void main(String[] args) {
        String[] nums = new String[]{"      -11919730356x", "-2147483648", "2147483647",
                "2147483648", "  -0012a42", "  010", "123", "-123"};
        for (String num : nums) {
            System.out.println(myAtoi(num));
        }
    }

    public static int myAtoi(String str) {
        str = str.trim();
        int h = 1;
        if (str.length() > 0) {
            if (str.charAt(0) == 43) {
                str = str.substring(1);
            } else if (str.charAt(0) == 45) {
                h = -1;
                str = str.substring(1);
            }
        }
        int res = 0;
        for (int i = 0, j = str.length(); i < j; i++) {
            int num = str.charAt(i) - '0';
            if (num < 0 || num > 9) {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 ||
                    res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < num) {
                return h == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = num + res * 10;
        }
        return res * h;
    }

}
