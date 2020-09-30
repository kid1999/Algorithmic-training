package base;

import java.util.Arrays;

/**
 * @author kid1999
 * @create 2020-09-29 22:41
 * @description KMP算法
 **/
public class KMP {
    public static void main(String[] args) {
        String s = "ababaaba";
        int[] next = getNext("abaabc");
        System.out.println(Arrays.toString(next));
        System.out.println(Arrays.toString(getNextVal(s)));;
    }
    /**
     * 获取next数组
     * @param pattern
     */
    private static int[] getNext(String pattern) {
        int j = 0;
        int k = -1;
        int len = pattern.length();
        int next[] = new int[len];
        next[0] = -1;
        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                j++;
                k++;
                next[j] = k;
            } else {
                // 比较到第K个字符，说明p[0——k-1]字符串和p[j-k——j-1]字符串相等，而next[k]表示
                // p[0——k-1]的前缀和后缀的最长共有长度，所接下来可以直接比较p[next[k]]和p[j]
                k = next[k];
            }
        }
        return next;
    }


    /**
     * get nextval
     * @param T
     * @return
     */
    private static int[] getNextVal(String T){
        int [] nextVal = new int[T.length()];
        int j = 0;
        int k = -1;
        nextVal[0] = -1;
        while (j<T.length()-1){
            if (k == -1||T.charAt(j) == T.charAt(k)){
                j++;
                k++;
                if (T.charAt(j) != T.charAt(k))
                    nextVal[j] = k;
                else
                    nextVal[j] = nextVal[k];
            }else
                k = nextVal[k];
        }
        return nextVal;
    }


    /**
     * kmp算法
     * @param s
     * @param pattern
     * @return
     */
    private static int kmp(String s, String pattern) {
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();

        int[] next = getNext(pattern);

        while (i < slen && j < plen) {

            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }

            }

            if (j == plen) {
                return i - j;
            }
        }
        return -1;
    }

}