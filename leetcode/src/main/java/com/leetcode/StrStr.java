package com.leetcode;

/**
 * Created by mengtian on 2018/3/5
 * <p>
 * https://leetcode.com/problems/implement-strstr/description/
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("hello", "a"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
