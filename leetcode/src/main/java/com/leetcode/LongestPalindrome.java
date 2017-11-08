package com.leetcode;

/**
 * <<<<<<< HEAD
 * Created by mengtian on 2017/11/6
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 最长回文子串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String[] str = new String[]{"babad", "abcda", "ababababa", "abb", "cbbd"};
        for (String s : str) {
            System.out.println(s + " : " + manacher(s));
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

    //manacher算法
    //code from https://github.com/phishman3579/java-algorithms-implementation/blob/master/test/com/jwetherell/algorithms/strings/test/ManacherTests.java
    public static String manacher(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int sLength = s.length();
        final char[] arr = new char[2 * s.length() + 1];
        for (int i = sLength - 1; i >= 0; i--) {
            arr[2 * i + 1] = s.charAt(i);
            arr[2 * i] = '#';
        }
        arr[2 * sLength] = '#';
        int arrLength = arr.length;
        int[] LPS = new int[arrLength + 1];
        int p = 0;
        for (int i = 1; i < arrLength; i++) {
            LPS[i] = 0;
            if (LPS[p] + p >= i) {
                LPS[i] = Math.min(LPS[2 * p - i], p + LPS[p] - i);
            }
            while (i + LPS[i] + 1 <= arrLength && i - LPS[i] - 1 >= 0 && arr[i + LPS[i] + 1] == arr[i - LPS[i] - 1]) {
                LPS[i]++;
            }
            if (p + LPS[p] < i + LPS[i]) {
                p = i;
            }
        }
        int valueMax = 0;
        int indexMax = 0;
        for (int i = 0; i < arrLength; i++) {
            if (valueMax < LPS[i]) {
                valueMax = LPS[i];
                indexMax = i;
            }
        }
        int palindromeSpan = valueMax / 2;
        if (indexMax % 2 == 0) {
            return s.substring(indexMax / 2 - palindromeSpan, indexMax / 2 + palindromeSpan);
        } else {
            return s.substring(indexMax / 2 - palindromeSpan, indexMax / 2 + palindromeSpan + 1);
        }

    }
}
