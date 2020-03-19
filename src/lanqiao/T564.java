package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/19 14:35
 **/
public class T564 {
    private static int res;
    private static int[] func;
    private static int[][] vis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        func = new int[]{-1,0,0,1,1,0,0,-1};
        vis = new int[n][m];
        int[][] arr = new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                res = Math.max(res,dfs(arr,i,j));
            }
        }
        System.out.println(res);
    }

    public static int dfs(int[][]arr,int i,int j){
        if(vis[i][j] != 0) return vis[i][j];
        int dep = 0;
        for (int k = 0; k <4 ; k++) {
            if(i+func[2*k]<0||i+func[2*k]>=arr.length||j+func[2*k+1]<0||j+func[2*k+1]>=arr[0].length) continue;
            if(arr[i+func[2*k]][j+func[2*k+1]]<arr[i][j]){
                dep = Math.max(dep,dfs(arr,i+func[2*k],j+func[2*k+1]));
            }
        }
        vis[i][j] = dep+1;
        return dep + 1;
    }
}
