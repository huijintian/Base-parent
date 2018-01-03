package com.leetcode;

/**
 * Created by mengtian on 2018/1/3
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{1, 1, 2}));
    }

    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
