package com.leetcode;

/**
 * Created by mengtian on 2017/11/16
 */
public class RegularMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));

        System.out.println("-----------");

        System.out.println(isMatch2("aa", "a"));
        System.out.println(isMatch2("aa", "aa"));
        System.out.println(isMatch2("aaa", "aa"));
        System.out.println(isMatch2("aa", "a*"));
        System.out.println(isMatch2("aa", ".*"));
        System.out.println(isMatch2("ab", ".*"));
        System.out.println(isMatch2("aab", "c*a*b"));
    }

    /**
     * code from leetcode discuss
     * https://leetcode.com/problems/regular-expression-matching/discuss/
     * <p>
     * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     * 3, If p.charAt(j) == '*':
     * here are two sub conditions:
     * 1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     * 2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     * dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
     * or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     * or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        // code from leetcode discuss
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    /**
     * 递归方式
     * <p>
     * http://www.cnblogs.com/grandyang/p/4461713.html
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        if (p.charAt(1) != '*') {
            if (s.isEmpty())
                return false;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch2(s.substring(1), p.substring(1));
        }
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch2(s, p.substring(2))) return true;
            s = s.substring(1);
        }
        return isMatch2(s, p.substring(2));
    }
}
