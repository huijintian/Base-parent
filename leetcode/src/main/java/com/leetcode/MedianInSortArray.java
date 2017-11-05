package com.leetcode;

import java.util.Arrays;

/**
 * Created by mengtian on 2017/11/5
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * 操蛋的题目，描述不清。
 * 题目是取两个数组排序之后的数组的中间数。
 */
public class MedianInSortArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4};
        int[] nums2 = new int[]{};
        /*int[] nums1 = new int[]{1, 1};
        int[] nums2 = new int[]{1, 2};*/
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //合并两个数组
        int num1Max = nums1.length > 0 ? nums1[nums1.length - 1] : 0;
        int num2Max = nums2.length > 0 ? nums2[nums2.length - 1] : 0;
        int maxNum = num1Max > num2Max ? num1Max : num2Max;
        int[] mergeSrot = new int[maxNum + 1];
        for (int num : nums1) {
            mergeSrot[num] += 1;
        }
        for (int num : nums2) {
            mergeSrot[num] += 1;
        }
        int sortSize = 0;
        for (int i = 0; i < mergeSrot.length; i++) {
            if (mergeSrot[i] > 0) {
                sortSize += mergeSrot[i];
            }
        }
        int[] sort = new int[sortSize];
        int index = 0;
        for (int i = 0; i < mergeSrot.length; i++) {
            while (mergeSrot[i] >= 1) {
                sort[index] = i;
                index++;
                mergeSrot[i] -= 1;
            }
        }
        if (sort.length % 2 != 0) {
            return sort[sort.length / 2];
        } else {
            return (sort[sort.length / 2 - 1] + sort[sort.length / 2]) * 1.0 / 2;
        }
    }
}
