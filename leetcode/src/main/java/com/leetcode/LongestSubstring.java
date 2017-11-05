package com.leetcode;

/**
 * Created by mengtian on 2017/11/3
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstring {

    public static void main(String[] args) {
        //不是最优解
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        //存放每个子串的大小
        int length = 0;
        for (int i = 0; i < str.length; i++) {
            int[] move = new int[127];
            move[str[i] - 0] = 1;
            for (int j = i + 1; j < str.length; j++) {
                int subLength = j - i;

                //碰到重复的字符
                if (move[str[j] - 0] == 1) {
                    length = subLength > length ? subLength : length;
                    break;
                }
                move[str[j] - 0] = 1;
                length = subLength + 1 > length ? subLength + 1 : length;
            }
        }
        return length == 0 ? s.length() : length;
    }
}
