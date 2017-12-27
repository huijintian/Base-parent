package com.leetcode;

import java.util.Stack;

/**
 * Created by mengtian on 2017/12/12
 * <p>
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class IsValid {
    public static void main(String[] args) {
        String[] strs = new String[]{"(([()]))", "([)]", "()[]{}", "(]", "()"};
        for (String s : strs) {
            System.out.println(new IsValid().IsValid(s));
        }
    }

    public boolean IsValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
