package com.example.algorithm.dp;

/**
 * create by Freedom on 2020/6/23
 * 最长公共子序列
 *
 * ◼ 假设 2 个字符串分别是 str1、str2
 *  i ∈ [1, str1.length]
 *  j ∈ [1, str2.length]
 * ◼ 假设 dp(i, j) 是以 str1[i – 1]、str2[j – 1] 结尾的最长公共子串长度
 *  dp(i, 0)、dp(0, j) 初始值均为 0
 *  如果 str1[i – 1] = str2[j – 1]，那么 dp(i, j) = dp(i – 1, j – 1) + 1
 *  如果 str1[i – 1] ≠ str2[j – 1]，那么 dp(i, j) = 0
 * ◼ 最长公共子串的长度是所有 dp(i, j) 中的最大值 max { dp(i, j) }
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(lcs2("ABDCBA", "ABBA"));
    }

    static int lcs(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        char[] chars1 = str1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = str2.toCharArray();
        if (chars2.length == 0) return 0;
        char[] rowsChars = chars1, colsChars = chars2;
        if (chars1.length < chars2.length) {
            colsChars = chars1;
            rowsChars = chars2;
        }

        int[] dp = new int[colsChars.length + 1];
        int max = 0;
        for (int row = 1; row <= rowsChars.length; row++) {
            for (int col = colsChars.length; col >= 1; col--) {
                if (chars1[row - 1] != chars2[col - 1]) {
                    dp[col] = 0;
                } else {
                    dp[col] = dp[col - 1] + 1;
                    max = Math.max(dp[col], max);
                }
            }
        }
        return max;
    }

    static int lcs2(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        char[] chars1 = str1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = str2.toCharArray();
        if (chars2.length == 0) return 0;
        char[] rowsChars = chars1, colsChars = chars2;
        if (chars1.length < chars2.length) {
            colsChars = chars1;
            rowsChars = chars2;
        }

        int[] dp = new int[colsChars.length + 1];
        int max = 0;
        for (int row = 1; row <= rowsChars.length; row++) {
            int cur = 0;
            for (int col = 1; col <= colsChars.length; col++) {
                int leftTop = cur;
                cur = dp[col];
                if (chars1[row - 1] != chars2[col - 1]) {
                    dp[col] = 0;
                } else {
                    dp[col] = leftTop + 1;
                    max = Math.max(dp[col], max);
                }
            }
        }
        return max;
    }


    static int lcs1(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        char[] chars1 = str1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = str2.toCharArray();
        if (chars2.length == 0) return 0;
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] != chars2[j - 1]) continue;
                dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
