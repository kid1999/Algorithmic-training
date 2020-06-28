package LeetCode;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/27 22:30
 **/
public class week29 {
    public static void main(String[] args) {

    }

    // 1
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        int n = salary.length;
        for (int i:salary) {
            max = Math.max(max,i);
            min = Math.min(min,i);
            sum += i;
        }
        return (sum-max-min) / (n-2);
    }
    // 2
    public int kthFactor(int n, int k) {
        int num = 1;
        while (num <= n){
            if(n%num == 0) k--;
            if(k == 0) return num;
            num++;
        }
        return -1;
    }


    // 3
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int[][] dp  = new int[len+1][2];
        dp[0][1] = -1;
        int max = 0;
        for (int i = 1; i <=len ; i++) {
            if(nums[i-1] == 1){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] + 1;
            }else{
                max =Math.max(max,dp[i-1][1]);
                dp[i][1] = dp[i-1][0];
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i <=len ; i++) {
            max = Math.max(max,dp[i][1]);
        }
        return max;
    }

    // 4
    public class NodeTask {
        private Integer id;
        private Set<Integer> next;

        public NodeTask(Integer id) {
            this.id = id;
            next = new HashSet<>();
        }

        public NodeTask addDependence(Integer id) {
            this.next.add(id);
            return this;
        }
    }

    private int max = 0;
    private int[] map;
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int sum = 0;
        for (int i = 1; i <=16 ; i++) {
            map = new int[20];
            dfs(dependencies,i,1);
            for (int count:map) {
                if(count > k) max += Math.ceil(count/k);
            }
            sum = Math.max(sum,max);
        }

        return sum;
    }
    void dfs(int[][] dependencies,int id,int len){
        map[id]++;
        for (int [] arr:dependencies) {
            if(arr[0] == id) dfs(dependencies,arr[1],len+1);
        }
        max = Math.max(max,len);
    }


}
