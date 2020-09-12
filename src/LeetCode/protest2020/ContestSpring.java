package LeetCode.protest2020;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/18 14:56
 **/
public class ContestSpring {

    // 1

    public int minCount(int[] coins) {
        int res = 0;
        for (int i = 0; i <coins.length ; i++) {
            res += coins[i] / 2;
            res += coins[i] % 2;
        }
        return res;
    }
    // 2
    static int res;
    public int numWays(int n, int[][] relation, int k) {
        boolean[][] vis = new boolean[n][n];
        res = 0;
        for (int i = 0; i <relation.length ; i++) {
            vis[relation[i][0]][relation[i][1]] = true;
        }
        dfs(k,vis,0);
        return res;
    }
    public static void dfs(int k,boolean[][] vis,int num){
        if(k == 0){
            if(num == vis.length-1) res++;
            return;
        }
        for (int i = 0; i < vis.length ; i++) {
            if(vis[num][i]) dfs(k-1,vis,i);
        }
    }

    // 3

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[][] dp = new int[increase.length][3];
        int[] tmp = {0,0,0};
        for (int i = 0; i <increase.length ; i++) {
            dp[i][0] = tmp[0] + increase[i][0];
            dp[i][1] = tmp[1] + increase[i][1];
            dp[i][2] = tmp[2] + increase[i][2];
            tmp[0] = dp[i][0];
            tmp[1] = dp[i][1];
            tmp[2] = dp[i][2];
//            System.out.println(tmp[0] + " " + tmp[1] + " " + tmp[2]);
        }
        int[] res = new int[requirements.length];
        for (int i = 0; i <requirements.length ; i++) {
            int l = 0;
            int r = dp.length-1;
            if(requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] == 0){
                res[i] = 0;
                continue;
            }
            if(!max(dp[r],requirements[i])){
                res[i] = -1;
                continue;
            }
            while (l < r)
            {
                int mid = l + r>> 1;   //向右逼近时保证+1向上取整
                if (max(dp[mid],requirements[i])) r = mid;
                else l = mid + 1;
            }
            res[i] = l+1;
        }
        return res;
    }
    // a max b min
    public static boolean max(int[] a,int[] b){
        for (int i = 0; i < 3 ; i++) {
            if(a[i] < b[i]) return false;
        }
        return true;
    }


    // 4

//    public static int minJump(int[] jump) {
//        int len = jump.length;
//        int[] dp = new int[jump.length];
//        for (int i = jump.length-1; i >=0 ; i--) {
//            if(i + jump[i] >= jump.length) dp[i] = 1;
//            else dp[i] = dp[i+jump[i]] + 1;
//        }
//        int[] mins = new int[len];
//        int min = len;
//        for (int i = 0; i < len; i++) {
//            if(dp[i] <= min){
//                min = dp[i];
//                mins[i] = min;
//            }else{
//                mins[i] = min +1;
//            }
//        }
//        for (int i = 0; i <len ; i++) {
//            if(mins[i] == 1) dp[i] = 1;
//            else dp[i] = Math.min(mins[i],dp[i+jump[i]]) + 1;
//            System.out.println();
//        }
//        return dp[0];
//    }


    // 5

}
