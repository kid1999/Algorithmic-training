package LeetCode;

import javafx.util.Pair;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/28 10:28
 **/
public class week195 {
    public static void main(String[] args) {
        int[] dp = {3,5,6,7};
        System.out.println(numSubseq(dp,9));
    }

    // 1
    public static boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int x = 0;
        int y = 0;
        Set<Integer> s = new HashSet<>();
        s.add(0);
        map.put(0,s);
        for (char c:path.toCharArray()) {
            if(c == 'N') x-=1;
            else if(c == 'S') x+=1;
            else if(c == 'E') y+=1;
            else y-=1;
            if(!map.containsKey(x)) map.put(x,new HashSet<>());
            Set<Integer> set = map.get(x);
            if(set.contains(y)) return true;
            else set.add(y);
        }
        return false;
    }

    // 2
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n:arr) {
            int other = ((n%k)+k)%k;
            map.put(other,map.getOrDefault(other,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(key == 0 && value%2 != 0) return false;
            else if(key == 0) continue;
            if(!map.containsKey(k-key)) return false;
            if(map.get(k-key) != value) return false;
        }
        return true;
    }
    // 3
    public static int numSubseq(int[] nums, int target) {
        int mod = 1000000000 + 7;
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int l = 0, r;
        int count = 0;
        if(nums[0]*2 <= target) count+=1;
        min.add(nums[0]);
        max.add(nums[0]);
        for (r = 1; r < nums.length; r++) {
            int num = nums[r];
            min.add(num);
            max.add(num);
            if(max.peek() + min.peek() > target){
                while (l<=r && max.peek() + min.peek() <= target){
                    min.remove(nums[l]);
                    max.remove(nums[l]);
                    l++;
                }
            }
            count++;
        }
        return count;
    }

    // 4
    static class pair{
        int key;
        int value;

        public pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<pair> queue = new PriorityQueue<>();
        int ans = Integer.MIN_VALUE;
        for (int[] arr:points) {
            int x = arr[0],y = arr[1];
            while (!queue.isEmpty() && queue.peek().value < x-k) queue.poll();
            if(!queue.isEmpty()) ans = Math.max(ans,queue.peek().key + y + x);
            queue.add(new pair(y-x,x));
        }
        return ans;
    }
}
