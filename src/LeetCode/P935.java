package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/7 11:27
 **/
public class P935 {
    public static void main(String[] args) {
//        System.out.println(knightDialer(3));
    }

    // dfs gg
//    static int[] func_x;
//    static int[] func_y;
//    public static int knightDialer(int N) {
//        int res = 0;
//        func_x = new int[]{1,2,2,1,-1,-2,-2,-1};
//        func_y = new int[]{-2,-1,1,2,2,1,-1,-2};
//        boolean[][] vis = new boolean[5][4];
//        for (int i = 1; i <=4 ; i++) {
//            for (int j = 1; j <=3 ; j++) {
//                res += dfs(vis,i,j,N-1);
//            }
//        }
//        return res%1000000007;
//    }
//
//    public static int dfs(boolean[][] vis,int i,int j,int count){
//        if(i==4 && (j==1 || j==3)) return 0;
//        if(count == 0) return 1;
//        int sum = 0;
//        for (int k = 0; k <8 ; k++) {
//            int y = i+func_y[k];
//            int x = j+func_x[k];
//            if(y>=1 && y<=4 && x>=1 && x<=3 && !vis[y][x]){
//                vis[y][x] = true;
//                sum += dfs(vis,y,x,count-1);
//                vis[y][x] = false;
//            }
//        }
//        return sum%1000000007;
//    }




    /** 假设穷举，1后面可以按6和8，6可以按1 7 0，发现又出现了1，而1只能按6 8
     * 所以我们就可以想到用动态规划求解，而dp采用的是自底向上，所以先求出N为i-1时，
     * 再求出i，因此就可以写出状态转移方程，假设求最后一位是0,号码长度为j,则
     * dp[0][j] = dp[4][j - 1] + dp[6][j - 1]
     * 其实很好理解，假如要按两位的号码，如果最后一位是0，那么只能从4或6才能跳到0，
     * 因此只要从一位号码的中选取4和6相加即可，三位号码同理，
     * dp[0][3] = dp[4][2] + dp[6][2]
     * 而dp[4][2] =dp[3][1] + dp[9][1] + dp[0][1];
     * 所以自定向上，答案就出来了。
     * */
    public int knightDialer(int N) {
        long[][] dp = new long[10][N + 1];
        int mod = 1000000007;
        for (int i = 0; i < 10; i++) {  //base条件，即一位号码的数量
            dp[i][1] = 1;
        }
        //进行动态规划，自底向上
        for (int j = 2; j < N + 1; j++) {
            dp[0][j] = ((dp[4][j - 1] + dp[6][j - 1]) % mod);
            dp[1][j] = ((dp[6][j - 1] + dp[8][j - 1]) % mod);
            dp[2][j] = ((dp[7][j - 1] + dp[9][j - 1]) % mod);
            dp[3][j] = ((dp[4][j - 1] + dp[8][j - 1]) % mod);
            dp[4][j] = ((dp[3][j - 1] + dp[9][j - 1] + dp[0][j - 1]) % mod);
            dp[6][j] = ((dp[1][j - 1] + dp[7][j - 1] + dp[0][j - 1]) % mod);
            dp[7][j] = ((dp[2][j - 1] + dp[6][j - 1]) % mod);
            dp[8][j] = ((dp[1][j - 1] + dp[3][j - 1]) % mod);
            dp[9][j] = ((dp[2][j - 1] + dp[4][j - 1]) % mod);
        }
        //进行相加
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[i][N]) % mod;
        }
        return (int) sum;
    }
}
