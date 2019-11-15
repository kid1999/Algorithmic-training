package LuoGu;

import java.util.Scanner;

/**
 * @auther: kid1999
 * @date: 2019/11/15 10:44
 * @desc: P1118
 **/
public class P1118 {
    static int n,res;
    static boolean[] vis;
    static int[] arr,nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        res = sc.nextInt();
        arr = createList(n);
        nums = new int[n+1];
        vis = new boolean[n+1];
        dfs(0,0);
    }

    public static int[] createList(int n){
        int[][] dp = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[n-1];
    }



    public static void dfs(int index,int count){
        if(count > res) return;
        if(count == res && index == n){
            for (int i = 0; i <n ; i++)
                System.out.print(nums[i] + " ");
            System.exit(0);
        }
        for (int i = 1; i <=n ; i++) {
            if(!vis[i]){
                vis[i] = true;
                nums[index] = i;
                dfs(index+1,count + arr[index]*i);
                vis[i] = false;
            }
        }
    }

}
