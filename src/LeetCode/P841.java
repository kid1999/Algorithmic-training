package LeetCode;

import java.util.List;

/**
 * @author kid1999
 * @date 2020/8/31 16:49
 * @desc
 **/
public class P841 {
    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms,vis,0);
        for (boolean f:vis) {
            if(!f) return false;
        }
        return true;
    }
    public static void dfs(List<List<Integer>> rooms,boolean[] vis,int i){
        if (vis[i]) return;
        else vis[i] = true;
        for (int n:rooms.get(i)) {
            dfs(rooms,vis,n);
        }
    }
}
