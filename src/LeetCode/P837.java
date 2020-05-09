package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/9 9:54
 **/
public class P837 {
    public static void main(String[] args) {

    }


    // dfs gg
//    static double count;
//    static double res;
//    public static double new21Game(int N, int K, int W) {
//        count = 0;
//        res = 0;
//        dfs(N,K,W,0);
//        return res/count;
//    }
//    public static void dfs(int n,int k,int w,int sum){
//        if(sum >= k){
//            count++;
//            if(sum <= n) res++;
//            return;
//        }
//        for (int i = 1; i <=w ; i++) {
//            dfs(n,k,w,sum+i);
//        }
//    }

    // dp
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N+W+1];
        for (int i = K; i <=N ; i++) dp[i] = 1;
        double sum = 0;
        for (int i = 0; i <W ; i++) sum += dp[K+i];
        for (int i = K; i >=0 ; i--) {
            dp[i] = sum/W;
            sum += dp[i] - dp[i+W];
        }
        return dp[0];
    }

}
