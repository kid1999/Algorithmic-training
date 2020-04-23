package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/23 10:50
 **/
public class P887 {
    public static void main(String[] args) {
        System.out.println(superEggDrop(1,2));
    }

    // 朴素理解 超时
//    public static int superEggDrop(int K, int N) {
//        int[][] dp = new int[N+1][K+1];
//        for (int i = 0; i <=N ; i++) dp[i][1] = i;
//        for (int i = 1; i <=N ; i++) {      // i层
//            for (int j = 2; j <=K ; j++) {  // k个鸡蛋
//                int res = Integer.MAX_VALUE;
//                for (int k = 1; k <=i ; k++) {  // 寻找最小移动次数
//                    res = Math.min(res,Math.max(dp[k-1][j-1],dp[i-k][j]) + 1);
//                }
//                dp[i][j] = res;
//            }
//        }
//        return dp[N][K];
//    }

    // 1、无论你在哪层楼扔鸡蛋，鸡蛋只可能摔碎或者没摔碎，碎了的话就测楼下，没碎的话就测楼上。
    // 2、无论你上楼还是下楼，总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1（当前这层楼）。
    // 根据这个特点，可以写出下面的状态转移方程：
    // dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1
    // dp[k][m - 1] 就是楼上的楼层数，因为鸡蛋个数 k 不变，也就是鸡蛋没碎，扔鸡蛋次数 m 减一；
    // dp[k - 1][m - 1] 就是楼下的楼层数，因为鸡蛋个数 k 减一，也就是鸡蛋碎了，同时扔鸡蛋次数 m 减一。
    // 上述递推公式可以这样理解，一次扔鸡蛋至少能推测1层楼，剩余m-1次扔鸡蛋则分别可以推测dp[k-1][m-1]和dp[k][m-1]层楼
    // dp[k-1][m-1]表示如果这次扔鸡蛋破了，那么只剩下k-1个鸡蛋和m-1次扔鸡蛋的机会可以探测到的最高楼层数
    // dp[k][m-1]表示这次扔鸡蛋没有婆，还剩下k个鸡蛋和m-1次扔鸡蛋机会可以探测到的最高楼层数
    // 同时还有本身扔鸡蛋的这一层楼
    // 一共能够推测的楼层就是上述三者之和

//    public static int superEggDrop(int K, int N) {
//        int[][] dp = new int[K+1][N+1];
//        int res = 0;
//        while (dp[K][res] < N){
//            res++;
//            for (int i = 1; i <=K ; i++) {
//                dp[i][res] = 1 + dp[i-1][res-1] + dp[i][res-1];
//            }
//        }
//        return res;
//    }

    // 再次压缩：
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;
        while (dp[K] < N){
            for (int i = K; i > 0; i--)
                dp[i] = dp[i] + dp[i-1] + 1;
            ans++;
        }
        return ans;
    }
}
