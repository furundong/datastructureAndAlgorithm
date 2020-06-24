package com.example.algorithm.dp;

/**
 * create by Freedom on 2020/6/17
 * 假设有25分、20分、5分、1分的硬币，现要找给客户41分的零钱，如何办到硬币个数最少？
 * 此前用贪心策略得到的并非是最优解（贪心得到的解是 5 枚硬币）
 * <p>
 * ◼ 假设 dp(n) 是凑到 n 分需要的最少硬币个数
 * 如果第 1 次选择了 25 分的硬币，那么 dp(n) = dp(n – 25) + 1
 * 如果第 1 次选择了 20 分的硬币，那么 dp(n) = dp(n – 20) + 1
 * 如果第 1 次选择了 5 分的硬币，那么 dp(n) = dp(n – 5) + 1
 * 如果第 1 次选择了 1 分的硬币，那么 dp(n) = dp(n – 1) + 1
 * 所以 dp(n) = min { dp(n – 25), dp(n – 20), dp(n – 5), dp(n – 1) } + 1
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coins1(41));
        System.out.println(coins2(41));
        System.out.println(coins3(41));
        System.out.println(coins4(41, new int[]{1, 5, 20, 25}));
    }

    public static int coins4(int n, int[] faces) {
        if (n <= 0 || faces == null || faces.length == 0) {
            return Integer.MAX_VALUE;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE; //
            for (int face : faces) {
                if (i < face) continue;
                //dp[i - face] < 0 这个是因为dp[i] = -1 ， 有可能凑不齐，原因看37行
                //dp[i - face] >= min 有可能大于min，说明这个dp[i-face] 前面已经有值了，那么就让min等于这个最小值，也是动态规划的精华。这就是状态转移方程
                if (dp[i - face] < 0 || dp[i - face] >= min) continue; //这里是因为dp[n]的硬币选择如果是不满足的
                min = dp[i - face];
            }
            if (min == Integer.MAX_VALUE) { //说明这些face不可用。就比如faces是 5，20，21 ， 那么你的dp[1,2,3,4] 都是不可用的
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }

    /**
     * 递推,（自低向上的调用）
     *
     * ◼ 假设 dp(n) 是凑到 n 分需要的最少硬币个数
     * 如果第 1 次选择了 25 分的硬币，那么 dp(n) = dp(n – 25) + 1
     * 如果第 1 次选择了 20 分的硬币，那么 dp(n) = dp(n – 20) + 1
     * 如果第 1 次选择了 5 分的硬币，那么 dp(n) = dp(n – 5) + 1
     * 如果第 1 次选择了 1 分的硬币，那么 dp(n) = dp(n – 1) + 1
     * 所以 dp(n) = min { dp(n – 25), dp(n – 20), dp(n – 5), dp(n – 1) } + 1
     */
    public static int coins3(int n) {
        if (n <= 0) {
            return Integer.MAX_VALUE;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1]; //因为是从1开始的，那么我可以从一开始。
            if (i >= 5) min = Math.min(dp[i - 5], min);
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);
            dp[i] = min + 1;
            //min { dp(n – 25), dp(n – 20), dp(n – 5), dp(n – 1) } + 1
        }
        return dp[n];
    }

    /**
     * 记忆化搜索,（自顶向下的调用）
     */
    public static int coins2(int n) {
        if (n <= 0) {
            return Integer.MAX_VALUE;
        }
        int[] dp = new int[n + 1];
        int[] faces = {1, 5, 20, 25};
        for (int face : faces) {
            dp[face] = 1;
        }
        return coins2(n, dp);
    }

    private static int coins2(int n, int[] dp) {
        if (n <= 0) return Integer.MAX_VALUE;
        if (dp[n] == 0) {
            int min1 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));  // 比如n-25 = 16 ， 那么这里就返回各种16选择的硬币。
            int min2 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
            return Math.min(min1, min2) + 1;
        }
        return dp[n];
    }


    /**
     * 暴力递归
     */
    public static int coins1(int n) {
        //n就是选择n分的硬币
        if (n <= 0) {
            return Integer.MAX_VALUE;
        }
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        int min1 = Math.min(coins1(n - 25), coins1(n - 20));
        int min2 = Math.min(coins1(n - 5), coins1(n - 1));
        return Math.min(min1, min2) + 1;
    }

}
