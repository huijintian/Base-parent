package com.leetcode;

/**
 * Created by mengtian on 2017/11/22
 * <p>
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntToRoman {
    public static void main(String[] args) {

    }

    /**
     * 数字转为罗马字符
     * 基本字符
     * I
     * V
     * X
     * L
     * C
     * D
     * M
     * 相应的阿拉伯数字表示为
     * 1
     * 5
     * 10
     * 50
     * 100
     * 500
     * 1000
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        //leetcode discuss,
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
