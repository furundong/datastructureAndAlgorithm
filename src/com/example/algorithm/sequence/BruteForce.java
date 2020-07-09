package com.example.algorithm.sequence;

/**
 * create by Freedom on 2020/7/8
 */
public class BruteForce {

    public static int indexOf1(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        int tlen = text.length();
        int plen = pattern.length();
        if (tlen == 0 || plen == 0 || tlen < plen) return -1;
        int pi = 0, ti = 0;
        while (pi < plen && ti < tlen) {
            if (text.charAt(ti) == pattern.charAt(pi)) {
                pi++;
                ti++;
            } else {
                //ti-pi得意思是从哪个下标开始比， 是相等得。
                ti = ti - pi + 1;   //这行代码得意思是，pi是索引遍历得长度，ti跟pi一开始是同步得，因为不相等，所以ti+1，这个就是一直往后遍历。
                pi = 0;
            }
        }
        return pi == plen ? ti - pi : -1;
    }

    public static int indexOf2(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        int tlen = text.length();
        int plen = pattern.length();
        if (tlen == 0 || plen == 0 || tlen < plen) return -1;
        int pi = 0, ti = 0;
        //ti -pi 是指每一轮比较中 text 首个比较字符的位置 ，如果你不减这个pi，那么你在比较最后得元素得时候，你得ti已经在最后面了。这个时候不满足。
        // tlen - plen 是这个比较字符得最小临界值， 你这个ti索引比较不能小于这个临界值，否者就不用比较了，后面就没有比较得必要
        while (pi < plen && ti - pi <= tlen - plen) {
            if (text.charAt(ti) == pattern.charAt(pi)) {
                pi++;
                ti++;
            } else {
                //ti-pi得意思是从哪个下标开始比， 是相等得。
                ti = ti - pi + 1;   //这行代码得意思是，pi是索引遍历得长度，ti跟pi一开始是同步得，因为不相等，所以ti+1，这个就是一直往后遍历。
                pi = 0;
            }
        }
        return pi == plen ? ti - pi : -1;
    }

    public static int indexOf3(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        int tlen = text.length();
        int plen = pattern.length();
        if (tlen == 0 || plen == 0 || tlen < plen) return -1;
        int maxLen = tlen - plen;
        //ti <= maxLen 是最大的临界值
        for (int ti = 0; ti <= maxLen; ti++) {
            int pi = 0;
            while (pi < plen) {
                if(text.charAt(ti+pi) != pattern.charAt(pi)) break;
                pi++;
            }
            if (pi == plen) return ti;
        }
        return -1;
    }
}
