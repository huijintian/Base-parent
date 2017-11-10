package com.leetcode;

/**
 * Created by mengtian on 2017/11/10
 * <p>
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Reverse {

    public static void main(String[] args) {
        int[] a = new int[]{-2147483412, 1534236469, 10, -123, 123};
        for (int i : a) {
            System.out.println(i + "," + reverse(i));
        }
    }

    //code from http://www.cnblogs.com/grandyang/p/4125588.html
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) >= Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
