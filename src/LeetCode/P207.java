package LeetCode;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/16 11:12
 **/
public class P207 {
    public static void main(String[] args) {

    }

    // 通过 DFS 判断图中是否有环。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] vis = new int[numCourses+1];
        for (int[] arr:prerequisites) {
            if(!map.containsKey(arr[0])){
                List<Integer> list = new ArrayList<>();
                map.put(arr[0],list);
            }
            List<Integer> list = map.get(arr[0]);
            list.add(arr[1]);
        }
        for (int i = 0; i <numCourses ; i++) {
            if(!dfs(map,vis,i)) return false;
        }
        return true;
    }
    boolean dfs(HashMap<Integer, List<Integer>> map,int[] vis,int i){
        if(vis[i] == 1) return false;
        if(vis[i] == -1) return true;
        vis[i] = 1;
        for (int n:map.get(i)) {
            if(!dfs(map,vis,n)) return false;
        }
        vis[i] = -1;
        return true;
    }
}
