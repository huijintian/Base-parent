package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengtian on 2017/11/23
 * <p>
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInt {

    public static void main(String[] args) {
        String[] romans = new String[]{"MCMXCVI", "VIII", "IV"};
        for (String s : romans) {
            System.out.println(romanToInt(s));
        }
    }

    public static int romanToInt(String s) {
        //使用map不太好。可修改为switch case
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int res = 0;

        for (int i = 0, len = s.length(); i < len; i++) {
            if (i != len - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                res += romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i));
                i++;
            } else {
                res += romanMap.get(s.charAt(i));
            }
        }
        return res;
    }

}
