package com.example.algorithm.dp;

/**
 * create by Freedom on 2020/6/18
 */
public class MaxContinueSubArraySum {
    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     *  空间复杂度：O(1)，时间复杂度：O(n)
     */
    static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp <= 0) {
                dp = nums[i];
            } else {
                dp = dp + nums[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }

    static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            int prev = dp[i - 1];
            if (prev <= 0) { //如果前面的最大子序列和是小于0的，那么就选自己
                dp[i] = nums[i];
            } else {
                dp[i] = prev + nums[i]; //否则就相加。
            }
            max = Math.max(dp[i], max); //最大值是记录，并且返回。
        }
        return max;
    }
}
