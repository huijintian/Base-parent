package com.leetcode;

/**
 * Created by mengtian on 2017/11/7
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * <p>
 * 最长回文子串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String[] str = new String[]{"cbbd", "babad", "aafd", "a", "abcda", "abcde"};
        for (String s : str) {
            System.out.println(s + ":" + longestPalindrome(s));
        }
    }

    //知乎上的解法
    //https://www.zhihu.com/question/40965749
    public static String longestPalindrome(String s) {
        for (int size = s.length(); size > 0; size--) {
            for (int low = 0, high = low + size - 1; high < s.length(); low++, high++) {
                if (shrinkCheckPalindrome(s, low, high)) {
                    return s.substring(low, high + 1);
                }
            }
        }
        return s.substring(0, 1);
    }

    private static boolean shrinkCheckPalindrome(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }
}
