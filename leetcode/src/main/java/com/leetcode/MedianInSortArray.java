package com.leetcode;


/**
 * Created by mengtian on 2017/11/5
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * <p>
 * 操蛋的题目，描述不清。
 * 题目是取两个数组排序之后的数组的中间数。
 */
public class MedianInSortArray {
		public static void main(String[] args) {
				int[] nums1 = new int[]{1};
				int[] nums2 = new int[]{1};
				/*int[] nums1 = new int[]{1, 1};
				int[] nums2 = new int[]{1, 2};*/
				System.out.println(findMedianSortedArrays2(nums1, nums2));
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
								sort[index++] = i;
								mergeSrot[i] -= 1;
						}
				}
				if (sort.length % 2 != 0) {
						return sort[sort.length / 2];
				} else {
						return (sort[sort.length / 2 - 1] + sort[sort.length / 2]) * 1.0 / 2;
				}
		}

		public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

				int[] mergeSrot = new int[nums1.length + nums2.length];
				if (nums1.length == 0 || nums2.length == 0) {
						mergeSrot = nums1.length == 0 ? nums2 : nums1;
				} else {
						int index = 0;
						int i = 0, j = 0;

						while (true) {
								while (i < nums1.length && (nums2.length - j == 0 || nums2[j] >= nums1[i])) {
										mergeSrot[index++] = nums1[i++];
								}
								while (j < nums2.length && (nums1.length - i == 0 || nums2[j] <= nums1[i])) {
										mergeSrot[index++] = nums2[j++];
								}
								if (i == nums1.length && j == nums2.length) {
										break;
								}
						}
				}

				if (mergeSrot.length % 2 != 0) {
						return mergeSrot[mergeSrot.length / 2];
				} else {
						return (mergeSrot[mergeSrot.length / 2 - 1] + mergeSrot[mergeSrot.length / 2]) * 1.0 / 2;
				}
		}
}
