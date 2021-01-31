package LeetCode;

import CCPC.test1.A;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kid1999
 * @create 2021-01-30 13:25
 * @description TODO
 **/
public class P778 {


    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        //优先队列，最小的先出来
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[2]-o2[2];
            }
        });
        queue.offer(new int[]{0,0,grid[0][0]});
        int ans = 0;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int dp = temp[2];
            ans = Math.max(ans,dp);
            if(x==n-1 && y==n-1){
                return ans;
            }
            //弹出来之后再标记，确定此刻为最小
            visited[x][y] = true;
            for(int[] dir:directions){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>=0 && nx<n && ny>=0 &&ny<n && !visited[nx][ny]){
                    queue.offer(new int[]{nx,ny,grid[nx][ny]});
                }
            }
        }
        return ans;
    }
}