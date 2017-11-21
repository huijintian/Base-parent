package com.leetcode;

/**
 * Created by mengtian on 2017/11/21
 * <p>
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 8, 23, 5};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {
        //from leetcode discuss
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
