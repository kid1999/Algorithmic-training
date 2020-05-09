package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/9 11:06
 **/
public class P808 {
    public static void main(String[] args) {

    }
        // dp
//    public double soupServings(int N) {
//        if(N>=4800) return 1.0;
//        int n = (int) Math.ceil(N/25.0);
//        double[][] dp = new double[n+1][n+1];
//        dp[0][0] = 0.5;
//        for (int i = 1; i <= n ; i++) {
//            dp[i][0] = 0;
//            dp[0][i] = 1;
//        }
//        for (int i = 1; i <= n; ++i){
//            int a1 = i - 4 > 0 ? i - 4 : 0;//不足4，按4算（实际上是不足100，按100算，然后分配完了，没有剩余）
//            int a2 = i - 3 > 0 ? i - 3 : 0;//不足3，按3算（实际上是不足75，按75算，然后分配完了，没有剩余）
//            int a3 = i - 2 > 0 ? i - 2 : 0;//不足2，按2算（实际上是不足50，按75算，然后分配完了，没有剩余）
//            int a4 = i - 1 > 0 ? i - 1 : 0;//不足1，按1算（实际上是不足25，按25算，然后分配完了，没有剩余）
//            for(int j = 1; j <= n; ++j) {
//                int b1 = j;
//                int b2 = j - 1 > 0 ? j - 1 : 0;//不足1，按1算（实际上是不足25，按25算，然后分配完了，没有剩余）
//                int b3 = j - 2 > 0 ? j - 2 : 0;//不足2，按2算（实际上是不足50，按75算，然后分配完了，没有剩余）
//                int b4 = j - 3 > 0 ? j - 3 : 0;//不足3，按3算（实际上是不足75，按75算，然后分配完了，没有剩余）
//                //状态转移方程：dp[i][j] = 0.25 * (dp[i-100][j] + dp[i-75][j-25] + dp[i-50][j-50] + dp[i-75][j-25])
//                //将N缩小为原来的25分之一的转移方程：dp[i][j] = 0.25 * (dp[i-4][j] + dp[i-3][j-1] + dp[i-2][j-2] + dp[i-3][j-1])
//                dp[i][j]= 0.25 * (dp[a1][b1] + dp[a2][b2] + dp[a3][b3] + dp[a4][b4]);
//            }
//        }
//        return dp[n][n];
//    }

    // dfs + 记忆化
    static Map<String,Double> map;
    public double soupServings(int N) {
        if(N>=4800) return 1;
        map = new HashMap<>();
        int n = (int) Math.ceil(N/25.0);
        return dfs(n,n);
    }
    public static double dfs(int i,int j){
        if(i<=0 && j<=0) return 0.5;
        else if(i<=0 && j>0) return 1;
        else if(i>0 && j<=0) return 0;
        else if(map.containsKey(i + " " + j)) return map.get(i + " " + j);
        else{
            double sum = 0.25*(dfs(i-4,j)+dfs(i-3,j-1)+
                    dfs(i-2,j-2)+dfs(i-1,j-3));
            map.put(i + " " + j,sum);
            return sum;
        }
    }
}
