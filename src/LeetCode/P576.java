package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/11 10:01
 **/
public class P576 {
    public static void main(String[] args) {
        System.out.println(findPaths(45,35,47,20,31));
    }


    static int[] func;
    static int[][][] vis;
    public static int findPaths(int m, int n, int N, int i, int j) {
        vis = new int[m+1][n+1][N+1];
        for(int x=0;x<m;x++)
            for(int y=0;y<n;y++)
                for(int z=0;z<N+1;z++)
                    vis[x][y][z]=-1;
        func = new int[]{-1,0,0,1,1,0,0,-1};
        return dfs(m,n,N,i,j);
    }
    private static int dfs(int m, int n, int N, int i, int j){
        if(i<0||i>=m||j<0||j>=n && N>=0) return 1;
        if(N<=0) return 0;
        if(vis[i][j][N] != -1) return vis[i][j][N];
        vis[i][j][N] = 0;
        for (int k = 0; k <4 ; k++) {
            vis[i][j][N] += dfs(m,n,N-1,i+func[2*k],j+func[2*k+1]);
        }
        return vis[i][j][N];
    }
}
