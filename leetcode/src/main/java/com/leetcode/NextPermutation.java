package com.leetcode;

/**
 * Created by mengtian on 2018/3/18
 * <p>
 * https://leetcode.com/problems/next-permutation/description/
 * <p>
 * https://leetcode.com/problems/next-permutation/discuss/13865/Sharing-my-clean-and-easy-understand-java-code-with-explanation
 */
public class NextPermutation {
    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 1, 5});
    }


    /**
     * 在当前序列中，从尾端往前寻找两个相邻元素，前一个记为first，后一个记为second，
     * 并且满足first 小于 second。然后再从尾端寻找另一个元素number，如果满足first 小于number，
     * 即将第first个元素与number元素对调，并将second元素之后（包括second）的所有元素颠倒排序，即求出下一个序列
     * <p>
     * example:
     * 6，3，4，9，8，7，1
     * 此时 first ＝ 4，second = 9
     * 从尾巴到前找到第一个大于first的数字，就是7
     * 交换4和7，即上面的swap函数，此时序列变成6，3，7，9，8，4，1
     * 再将second＝9以及以后的序列重新排序，让其从小到大排序，使得整体最小，即reverse一下（因为此时肯定是递减序列）
     * 得到最终的结果：6，3，7，1，4，8，9
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i != 0) {
            int x = nums.length - 1;
            for (; x >= i; x--) {
                if (nums[x] > nums[i - 1]) {
                    break;
                }
            }
            swap(nums, i - 1, x);
        }
        reverse(nums, i, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    private void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int x) {
        int t = nums[i];
        nums[i] = nums[x];
        nums[x] = t;
    }
}
