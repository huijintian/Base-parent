package com.leetcode;

/**
 * Created by mengtian on 2018/1/9
 * <p>
 * https://leetcode.com/problems/remove-element/description/
 * 题目没理解
 */
public class RemoveElement {
    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(new RemoveElement().removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            while (nums[i] == val && i < len) {
                nums[i] = nums[--len];
            }
        }
        return len;
    }
}
