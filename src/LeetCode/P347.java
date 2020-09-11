package LeetCode;

import javafx.util.Pair;

import java.util.*;

/**
 * @author kid1999
 * @date 2020/9/7 8:35
 * @desc
 **/
public class P347 {
    public static void main(String[] args) {

    }

//    public int[] topKFrequent(int[] nums, int k) {
//        int[] res = new int[k];
//        // TreeMap 默认Key升序
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int n: nums){
//            map.put(n,map.getOrDefault(n,0)+1);
//        }
//        List<Pair<Integer,Integer>> list = new ArrayList<>();
//        for(Map.Entry<Integer,Integer> e:map.entrySet()){
//            list.add(new Pair<>(e.getKey(),e.getValue()));
//        }
//        list.sort((a,b)->b.getValue()-a.getValue());
//        for (int i = 0; i <k ; i++) {
//            res[i] = list.get(i).getKey();
//        }
//        return res;
//    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, v) -> v = v == null ? 1 : v + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer key : map.keySet()) {
            if (heap.size() < k) heap.add(key);
            else if (map.get(key) > map.get(heap.peek())) {
                heap.poll();
                heap.add(key);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
