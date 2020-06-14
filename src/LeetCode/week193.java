package LeetCode;
import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/14 10:21
 **/
public class week193 {
    public static void main(String[] args) {
//        int[] arr = new int[]{5,5,4};
//        System.out.println(findLeastNumOfUniqueInts(arr,1));
        week193 w = new week193();
        w.test();
    }

    // 1
    public int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            int sum = 0;
            for (int j = 0; j <=i ; j++) {
                sum += nums[j];
            }
            arr[i] = sum;
        }
        return arr;
    }

    // 2
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<int[]> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int n:arr) {
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for (Map.Entry<Integer,Integer> entity:map.entrySet()) {
            list.add(new int[]{entity.getKey(),entity.getValue()});
        }
        int res = map.size();
        list.sort((a,b)->{
            return a[1]-b[1];
        });
        for (int [] a:list) {
            if(a[1] > k) break;
            k -= a[1];
            res--;
        }
        return res;
    }

    // 3
//    public int minDays(int[] bloomDay, int m, int k) {
//        int len =  bloomDay.length;
//        if(len <m*k) return -1;
//        int[][] dp = new int[len+1][m+1];
//        for (int i = 0; i <len ; i++) dp[0][i] = 0;
//        for (int i = k-1; i <len ; i++) {
//            int max_cost = Integer.MIN_VALUE;
//            for (int j = i; j >=0 ; j--) {
//                max_cost =  Math.max(max_cost,bloomDay[j]);
//            }
//            for (int j = 0; j <len ; j++) {
//                dp[i-k][j] =
//            }
//            dp[i]
//
//
//        }
//    }

    // 4
    void test(){
        int[] arr =  new int[]{-1,0,0,0,3};
        TreeAncestor t = new TreeAncestor(arr.length,arr);
        System.out.println(t.getKthAncestor(1,5));
    }

}
class TreeAncestor {
    int[] p = null;
    List<List<Integer>> list = null;
    boolean[] vis = null;
    public TreeAncestor(int n, int[] parent) {
        p = parent;
        vis = new boolean[p.length];
        list = new ArrayList<>();
        for (int i = 0; i <p.length ; i++) {
            if(!vis[i]){
                dfs(i);
                vis[i] = true;
            }
        }
    }

    public List<Integer> dfs(int node){
        if(node == -1) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(-1);
            list.add(tmp);
            return tmp;
        };
        List<Integer> tmp = null;
        if(vis[node]) tmp = new ArrayList<>(list.get(node));
        else tmp = new ArrayList<>(dfs(p[node]));
        tmp.add(p[node]);
        vis[node] = true;
        list.add(node,dfs(node));
        return tmp;
    }

    public int getKthAncestor(int node, int k) {
        if(list.get(node).size() < k) return -1;
        return list.get(node).get(k);
    }
}

//class TreeAncestor {
//    int[] p = null;
//    int n = 0;
//    public TreeAncestor(int n, int[] parent) {
//        p = parent;
//        this.n = n;
//    }
//
//    public int getKthAncestor(int node, int k) {
//        if(node >= n) return -1;
//        while(k>0){
//            k--;
//            if(node == -1) return -1;
//            node = p[node];
//        }
//        return node;
//    }
//}
