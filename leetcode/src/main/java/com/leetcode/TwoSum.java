package com.leetcode;

/**
 * Created by mengtian on 2017/11/1
 * <p>
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        for (int i : twoSum(nums, target)) {
            System.out.println(i);
        }
        for (int i : nextTwoSum(nums, target)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
            i++;
        }
        return null;
    }

    public static int[] nextTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
