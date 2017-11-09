package com.leetcode;

/**
 * Created by mengtian on 2017/11/9
 */
public class ZigZagConvertion {
    public static void main(String[] args) {
        String[] strs = new String[]{"AB", "PAYPALISHIRING"};
        for (String s : strs) {
            System.out.println(convert2(s, 3));
        }
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] zig = new char[s.length()][numRows];
        int index = 0, length = s.length();

        int row = 0, col = 0;
        boolean climb = true;
        while (index < length) {
            System.out.println(row + "," + col + ",climb:" + climb);
            zig[row][col] = s.charAt(index);
            index++;
            if (climb) {
                if (col != numRows - 1) {
                    col++;
                } else {
                    row++;
                    col--;
                    climb = false;
                }
            } else {
                if (col == 0) {
                    col++;
                    climb = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < zig.length; i++) {
                char w = zig[i][j];
                sb.append(w == '\u0000' ? "" : w);
            }
        }
        return sb.toString();
    }

    public static String convert2(String s, int rowNums) {
        int loop = 0;
        StringBuilder sb = new StringBuilder();
        while (loop <= rowNums) {
            int index = loop;
            while (index < s.length()) {
                System.out.println("loop:" + loop + ",index:" + index + ", char:" + s.charAt(index));
                sb.append(s.charAt(index));
                index += (rowNums + 1);
            }
            loop++;
        }
        return sb.toString();
    }
}
