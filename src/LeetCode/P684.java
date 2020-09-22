package LeetCode;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/17 9:33
 * @desc
 **/
public class P684 {
    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] f = new int[n+1];
        int[] res = {0,0};
        Arrays.fill(f,-1);
        for (int[] nums:edges) {
            int a = nums[0];
            int b = nums[1];
            if(union(a,b,f)){
                res = new int[]{a,b};
            }
        }
        return res;
    }
    public static int find_root(int x,int[] f){
        int x_root = x;
        while (f[x_root] != -1){
            x_root = f[x_root];
        }
        return x_root;
    }
    public static boolean union(int x,int y,int[] f){
        int x_root = find_root(x,f);
        int y_root = find_root(y,f);
        if(x_root != y_root){
            f[x_root] = y_root;
            return false;
        }else return true;
    }
}
