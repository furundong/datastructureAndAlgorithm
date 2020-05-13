package com.example.algorithm.sort.insertSort;

/**
 * create by Freedom on 2020/4/29
 */
public class binarySearch {
    public static int indexOf(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int begin = 0;
        int end = arr.length;
        while (begin < end) {
            int mid = (end + begin) >> 1; //这个end就要元素个数+1，左开右闭【），相加除2，就是中间的index，在代码中尽量不用 /
            if (value > arr[mid]) {
                begin = mid + 1;
            } else if (value < arr[mid]) {
                end = mid;
            } else
                return mid;
        }
        return -1;
    }
}
