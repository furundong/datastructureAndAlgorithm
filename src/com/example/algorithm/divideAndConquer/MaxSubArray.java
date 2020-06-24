package com.example.algorithm.divideAndConquer;

/**
 * create by Freedom on 2020/6/12
 */
public class MaxSubArray {

    //采用分治，
    /*
    ◼ 将序列均匀地分割成 2 个子序列
        [begin , end) = [begin , mid) + [mid , end)，mid = (begin + end) >> 1
    ◼ 假设 [begin , end) 的最大连续子序列和是 S[i , j) ，那么它有 3 种可能
        [i , j) 存在于 [begin , mid) 中，同时 S[i , j) 也是 [begin , mid) 的最大连续子序列和
        [i , j) 存在于 [mid , end) 中，同时 S[i , j) 也是 [mid , end) 的最大连续子序列和
        [i , j) 一部分存在于 [begin , mid) 中，另一部分存在于 [mid , end) 中
            ✓ [i , j) = [i , mid) + [mid , j)
            ✓ S[i , mid) = max { S[k , mid) }，begin ≤ k ＜ mid
            ✓ S[mid , j) = max { S[mid , k) }，mid ＜ k ≤ end
     */
    public static int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        return maxSubArray(arr, 0, arr.length);
    }

    /**
     * T(n) = T(n/2) + T(n/2) + O(n)
     *
     * 这个就是归并的时间复杂度了。
     */
    public static int maxSubArray(int[] arr, int begin, int end) {
        if (end - begin < 2) { //这里说明只有一个元素了。原样返回就好了。
            return arr[begin];
        }
        int mid = (begin + end) >> 1;

        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {//最后一个元素已经声明了，倒数第二个开始到第一个
            leftSum += arr[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += arr[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(leftMax + rightMax,
                Math.max(maxSubArray(arr, begin, mid), maxSubArray(arr, mid, end)));
    }

    public static int maxSubArray2(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (int begin = 0; begin < arr.length; begin++) {
            int sum = 0;
            for (int end = begin; end < arr.length; end++) {//从i到len，从j开始选择一个最小的。
                sum += arr[end];
                result = Math.max(sum, result);
            }
        }
        return result;
    }

    // 0, 1, 2, 3, 4
    // 1, 2, 3, 4
    public static int maxSubArray1(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (int begin = 0; begin < arr.length; begin++) {
            for (int end = begin; end < arr.length; end++) {//从i到len，从j开始选择一个最小的。
                int sum = 0;
                //这里可以优化，一开始的begin是不变的，后面的end是一直在加，
                // 我只需要跟据后面的end结果的值，再往后面加，就可以完成。
                for (int k = begin; k <= end; k++) {
                    sum += arr[k];
                }
                result = Math.max(sum, result);
            }
        }
        return result;
    }

}
