package LeetCode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/7 10:19
 **/
public class P526 {
    public static void main(String[] args) {
//        System.out.println(countArrangement(3));
    }

//    int count = 0;
//    public int countArrangement(int N) {
//        boolean[] visited = new boolean[N + 1];
//        dfs(N, 1, visited);
//        return count;
//    }
//    public void dfs(int N, int pos, boolean[] visited) {
//        if (pos > N)
//            count++;
//        for (int i = 1; i <= N; i++) {
//            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
//                visited[i] = true;
//                dfs(N, pos + 1, visited);
//                visited[i] = false;
//            }
//        }
//    }


    // 状压DP
    public int countArrangement(int N) {
        int dp[]=new int[1<<N];
        dp[0]=1;
        for(int i=0;i<dp.length;i++){
            int len=1;
            for(int j=0;j<N;j++)
                len+=i>>j&1;
            for(int j=1;j<=N;j++){
                if((i >> (j - 1) & 1)==0&& (j % len == 0 || len % j == 0)) {
                    dp[i | (1 << j - 1)] += dp[i];   // 或运算，进行状态转移
                }
            }
        }
        return dp[(1<<N)-1];
    }

}
