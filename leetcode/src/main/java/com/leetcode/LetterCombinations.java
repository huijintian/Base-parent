package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengtian on 2017/12/5
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(Character.getNumericValue('B'));
        System.out.println(letterCombinations("236"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.trim().length() == 0) {
            return new LinkedList<>();
        }
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}
