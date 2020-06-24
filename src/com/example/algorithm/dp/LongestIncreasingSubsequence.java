package com.example.algorithm.dp;

/**
 * create by Freedom on 2020/6/18
 * 最长上升子序列（最长递增子序列，Longest Increasing Subsequence，LIS）
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS2(new int[] {10, 2, 2, 5, 1, 7, 101, 18}));
        System.out.println(lengthOfLIS3(new int[] {10, 2, 2, 5, 1, 7, 101, 18}));
    }

    //这道题目可以用二分搜索。
    /*
        ◼ 把每个数字看做是一张扑克牌，从左到右按顺序处理每一个扑克牌
            将它压在（从左边数过来）第一个牌顶 ≥ 它的牌堆上面
            如果找不到牌顶 ≥ 它的牌堆，就在最右边新建一个牌堆，将它放入这个新牌堆中
        ◼ 当处理完所有牌，最终牌堆的数量就是最长上升子序列的长度
     */
    static int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //牌堆的个数。
        int len = 0;
        int[] top = new int[nums.length];
        for (int num : nums) {
            int begin = 0;
            int end = len;
            while (begin < end) {
                int mid = (begin + end)>>1;
                if (num > top[mid]) {
                    begin = mid + 1;
                }else{ //如果是 = 的情况那么我们也算在左边。
                    end = mid;
                }
            }

            top[begin] = num;
            if (begin == len) { //如果这个begin跟len相等（也就是跟end相等）， 那么就说明已经在最右边了。 那么就len++
                len++;
            }
        }
        return len;
    }

    /*
    牌顶
     */
    static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //牌堆的个数。
        int len = 0;
        int[] top = new int[nums.length];

        for (int num : nums) {
            //这个for就是遍历所有的nums，将nums的更小的赋值给top数组，一轮一轮的来，一次只操作一个。
            int i = 0;
            for (; i < len; i++) {
                if(top[i]>=num){ //如果成立，那么i肯定会<len, 下一轮就nums的下一个元素
                    top[i] = num;
                    break;
                }
            }
            //第一个轮是没有值的，所有一开始会走这里。
            //如果相等， 那么说明是下一个要求另一个牌堆
            if (i == len){
                len++;
                top[i] = num;
            }
        }
        return len;
    }

        /**
         * 动态规划
         */
    static int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1); //定义状态
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
