package com.leetcode;

/**
 * Created by mengtian on 2017/11/6
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 最长回文子串
 *
 *
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String[] str = new String[]{"abcda", "ababababa", "abb", "babad", "cbbd"};
        for (String s : str) {
            System.out.println(s + " : " + longestPalindrome(s));
        }
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String subString = "";
        int index = 0;
        while (index < s.length() - 1) {
            String str = "";
            if (s.charAt(index) == s.charAt(index + 1)) {
                str = getString(s, index, index + 1);
            }
            if (index > 0 && s.charAt(index - 1) == s.charAt(index + 1)) {
                String temp = getString(s, index - 1, index + 1);
                str = str.length() > temp.length() ? str : temp;
            }
            subString = subString.length() >= str.length() ? subString : str;
            index++;
        }

        return subString;
    }

    private static String getString(String s, int i, int j) {
        if (i == 0) {
            return s.substring(i, j + 1);
        }
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                if (j == s.length() || i == 0) {
                    break;
                }
                i--;
            } else {
                i++;
                break;
            }
        }
        System.out.println(i + ", " + j);
        return j == s.length() ? s.substring(i) : s.substring(i, j);
    }
}
