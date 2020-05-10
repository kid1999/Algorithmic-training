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

    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] dp = new int[N+2][N+2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
                else
                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
            }

        return dp[1][N] > 0;
    }
}
