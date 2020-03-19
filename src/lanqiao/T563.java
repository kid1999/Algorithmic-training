package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/19 15:16
 **/
public class T563 {
    static int max = 0;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(arr,n-1,0,0);
        System.out.print(count + " " + max);
    }
    public static void dfs(int[][] arr,int i,int j,int dep){
        dep += arr[i][j];
        if(i==0 && j==arr.length-1){
            if(dep == max) count++;
            if (dep>max){
                max = dep;
                count = 1;
            }
            return ;
        }
        if(i>0) dfs(arr,i-1,j,dep);
        if(j<arr.length-1) dfs(arr,i,j+1,dep);
    }
}
