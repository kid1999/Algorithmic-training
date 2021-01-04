package LeetCode;

import java.util.*;

/**
 * @author kid1999
 * @create 2021-01-03 10:29
 * @description TODO
 **/
public class week222 {
    public static void main(String[] args) {
        int[] arr = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        System.out.println(countPairs(arr));
    }

    // 1
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int res = 0;
        for (int i = 0; i <boxTypes.length && truckSize > 0 ; i++) {
            int[] b = boxTypes[i];
            if(b[0] > truckSize) res += (truckSize*b[1]);
            else {
                res += (b[0] * b[1]);
            }
            truckSize -= b[0];
        }
        return res;
    }


    // 2
    public static int countPairs(int[] deliciousness) {
        int mod = 1000000007;
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <deliciousness.length ; i++) {
            map.put(deliciousness[i],map.getOrDefault(deliciousness[i],0)+1);
        }
        int num = 1;
        for (int j = 1; j <=21 ; j++) {
            num *= 2;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                if (map.containsKey(num - k)) {
                    if (2 * k == num)
                        res += (map.get(num - k) - 1) * v;
                    else
                        res += map.get(num - k) * v;
                }
                res %= mod;
            }
        }
        return res;
    }



    // 3
    public int waysToSplit(int[] nums) {
        int res = 0;
        int mod = 100000007;
        int[] dp = new int[nums.length+1];
        for (int i = 0; i <nums.length ; i++) {
            dp[i+1] = dp[i] + nums[i];
        }
        return 0;
    }

    // 4



}