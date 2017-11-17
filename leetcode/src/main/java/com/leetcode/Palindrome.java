package com.leetcode;

/**
 * Created by mengtian on 2017/11/14
 * <p>
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int[] nums = new int[]{1000110001, 1000021, 1001, -2147447412, -2147483648, 12321, 123};
        for (int num : nums) {
            System.out.println("num: " + num + " isPalindrome:" + isPalindrome(num));
        }
    }

    /**
     * leetcode discuss code
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}
