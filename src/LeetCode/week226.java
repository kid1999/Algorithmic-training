package LeetCode;

import java.util.*;

/**
 * @author kid1999
 * @create 2021-01-31 10:16
 * @description TODO
 **/
public class week226 {
    public static void main(String[] args) {
        int[][] arr ={{-3,-9},{-5,3},{2,-9},{6,-3},{6,1},{5,3},{8,5},{-5,1},{7,2}};
    }

    // 1
    public static int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = lowLimit; i <=highLimit ; i++) {
            String n = i+"";
            int res = 0;
            for(char c:n.toCharArray()){
                res += (int) c-'0';
            }
            map.put(res,map.getOrDefault(res,0)+1);
        }
        int maxKey = 0,max = 0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int k = entry.getKey();
            int v=  entry.getValue();
            if(v > max){
                max = v;
                maxKey = k;
            }
        }
        return max;
    }


    // 2
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        int[] res = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] p : adjacentPairs) {
            List<Integer> list = map.get(p[0]);
            if (list == null) list = new ArrayList<>();
            list.add(p[1]);
            map.put(p[0], list);

            list = map.get(p[1]);
            if (list == null) list = new ArrayList<>();
            list.add(p[0]);
            map.put(p[1], list);
        }

        int start = 0;
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            res[idx++] = cur;
            for (int adj : map.get(cur)) {
                if (visited.add(adj)) {
                    q.offer(adj);
                }
            }
        }

        return res;
    }

    // 3

    // 4
}