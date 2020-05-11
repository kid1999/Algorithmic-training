package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/10 8:53
 **/
public class P877 {
    public static void main(String[] args) {

    }


    // 先手可以一直控制自己拿下标全为奇数或者全为偶数的石子，所以只要提前计算好偶数下标与奇数下标各自的总和，选大的那一方拿就必胜
//    public boolean stoneGame(int[] piles) {
//        return true;
//    }

    // 博弈dp
    // 辗转排除对手的最大值 取得最大值  dp[i][j] = max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[N+2][N+2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                dp[i+1][j+1] = Math.max(piles[i] - dp[i+2][j+1], piles[j] - dp[i+1][j]);
            }
        return dp[1][N] > 0;
    }
}
