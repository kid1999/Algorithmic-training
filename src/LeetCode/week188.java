package LeetCode;

import CCPC.test1.B;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/10 18:13
 **/
public class week188 {
    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> vis = new ArrayList<>();
        vis.add(false);
        vis.add(false);
        vis.add(true);
        vis.add(false);
        vis.add(false);
        vis.add(true);
        vis.add(false);
        System.out.println(minTime(7,arr,vis));
    }

    public List<String> buildArray(int[] target, int n) {
        String push = "Push";
        String pop = "Pop";
        List<String> res = new ArrayList<>();
        int k = 0;
        int len = target.length;
        for (int i = 1; i <=n ; i++) {
            if(len == k) return res;
            if(target[k++] == i) res.add(push);
            else {
                res.add(push);
                res.add(pop);
            }
        }
        return res;
    }



    public int countTriplets(int[] arr) {
        int len = arr.length;
        int ans = 0;
        for(int i = 0; i < len - 1; i ++){
            int sum = 0;
            for(int k = i; k < len ; k ++){
                sum ^= arr[k];
                if (sum == 0 && k > i) {        //两个区间 异或为0
                    ans += (k - i);
                }
            }
        }
        return ans;
    }


//    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
//        Arrays.sort(edges, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//        int[] dp = new int[n];
//        Arrays.fill(dp,99999);
//        dp[0] = 0;
//        boolean[] vis = new boolean[n];
//        for (int i = 0; i <edges.length ; i++) {
//            int[] arr = edges[i];
//            int a = arr[0],b = arr[1];
//            if(!vis[a]){
//                dp[b] = Math.min(dp[b],dp[a]+2);
//                vis[a] = true;
//            }else{
//                dp[b] = Math.min(dp[b],2);
//            }
//        }
//        int res = 0;
//        for (int i = 0; i <n ; i++) {
//            if (hasApple.get(i)){
//                res += dp[i];
//            }
//        }
//        return res;
//    }

    static Map<Integer,List<Integer>> map = new HashMap<>();
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int len = 0;
        for (boolean f:hasApple) {
            if (f) len++;
        }
        if(len == 0) return 0;
        if(len == 1 && hasApple.get(0)) return 1;
        // create tree
        for (int[] arr: edges) {
            if(map.containsKey(arr[0])){
                map.get(arr[0]).add(arr[1]);
            }else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[1]);
                map.put(arr[0],tmp);
            }
        }
        // bfs
       return bfs(0,hasApple);
    }


    /**
     * dfs判断从根节点cur出发的路径有没有苹果
     * 找到一个苹果即返回true
     */
    private static boolean dfs(int cur,List<Boolean> hasApple){
        if (hasApple.get(cur)) return true;
        if (!map.containsKey(cur)) return false;
        for (int son:map.get(cur)){
            if (dfs(son,hasApple)){
                return true;
            }
        }
        return false;
    }

    /**
     * bfs实现所有结点的标记以及计算总路径
     * @param cur
     * @param hasApple
     */
    private static int bfs(int cur,List<Boolean> hasApple){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addLast(0);
        int cnt=0;
        while (!deque.isEmpty()){
            int size=deque.size();
            for (int i=0;i<size;i++){
                int root=deque.pollFirst();
                List<Integer> sons=map.get(root);
                if (sons!=null){
                    for (int son:sons) {
                        if (dfs(son,hasApple)) cnt += 2;
                        deque.addLast(son);
                    }
                }
            }
        }
        return cnt;
    }
}
