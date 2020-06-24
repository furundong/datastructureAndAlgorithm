package com.example.algorithm.dp;

/**
 * create by Freedom on 2020/6/18
 * 最长公共子序列（Longest Common Subsequence，LCS）
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int len = lcs(new int[]{1, 3,5, 9, 10}, new int[]{1, 4, 9, 10});
        System.out.println(len);
    }

    /*
  非递归实现-滚动数组-一维数组
  */
   public static int lcs(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        int[] rowsNums = nums1, colsNums = nums2; //这里的rowsNums跟colsNums已经不一样了，
        if (nums1.length < nums2.length) { //挑比较小得做为列数，作为一个一维数组
            colsNums = nums1;
            rowsNums = nums2;
        }
        int[] dp = new int[colsNums.length + 1];
        for (int i = 1; i <= rowsNums.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsNums.length; j++) { //这个for循环不能写nums2.length，作为最小的。
                int leftTop = cur; // 这里直接存储当前得值，等会在两个值相等得时候， 需要用到上个得值，用得就是中间变量存储
                cur = dp[j];
                if (rowsNums[i - 1] == colsNums[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colsNums.length];
    }

    /*
   非递归实现-滚动数组-一维数组
   */
    static int lcs4(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= nums2.length; j++) {
                int leftTop = cur; // 这里直接存储当前得值，等会在两个值相等得时候， 需要用到上个得值，用得就是中间变量存储
                cur = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[nums2.length];
    }

    /*
    非递归实现-滚动数组-二维数组
    */
    static int lcs3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int row = i & 1;
            int prevRow = (i - 1) & 1;
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[row][j] = dp[prevRow][j - 1] + 1;
                } else {
                    dp[row][j] = Math.max(dp[prevRow][j], dp[row][j - 1]);
                }
            }
        }
        return dp[nums1.length & 1][nums2.length];
    }

    /*
     非递归实现-二维数组
     */
    static int lcs2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        //这里用length+1是因为这个nums[i-1]这个底部开始，那么在dp中就做1，0下标的开始的就都是0.
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    /*
    递归实现
     */
    static int lcs1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        return lcs1(nums1, nums1.length, nums2, nums2.length);
    }

    /*
    ◼ 求两个序列的最长公共子序列长度
        [1, 3, 5, 9, 10] 和 [1, 4, 9, 10] 的最长公共子序列是 [1, 9, 10]，长度为 3
        ABCBDAB 和 BDCABA 的最长公共子序列长度是 4，可能是
        ✓ ABCBDAB 和 BDCABA > BDAB
        ✓ ABCBDAB 和 BDCABA > BDAB
        ✓ ABCBDAB 和 BDCABA > BCAB
        ✓ ABCBDAB 和 BDCABA > BCBA

        ◼ 假设 2 个序列分别是 nums1、nums2
            i ∈ [1, nums1.length]
            j ∈ [1, nums2.length]
        ◼ 假设 dp(i, j) 是【nums1 前 i 个元素】与【nums2 前 j 个元素】的最长公共子序列长度
            dp(i, 0)、dp(0, j) 初始值均为 0
            如果 nums1[i – 1] = nums2[j – 1]，那么 dp(i, j) = dp(i – 1, j – 1) + 1
            如果 nums1[i – 1] ≠ nums2[j – 1]，那么 dp(i, j) = max { dp(i – 1, j), dp(i, j – 1) }
     */
    private static int lcs1(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (nums1[i - 1] == nums2[j - 1]) {
            return lcs1(nums1, i - 1, nums2, j - 1) + 1;
        }
        return Math.max(lcs1(nums1, i - 1, nums2, j), lcs1(nums1, i, nums2, j - 1));
    }
}
