package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: kid1999
 * @desc:
 * @date: 2020/8/16 10:29
 **/
public class week202 {

    // 1
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int n:arr) {
            if(n%2==1) count++;
            else count = 0;
            if(count >= 3) return true;
        }
        return false;
    }


    // 2
    public int minOperations(int n) {
        int sum = 0;
        if(n%2==1){
            for (int i = 1; i <=n/2 ; i++) {
                sum += 2*i;
            }
        }else {
            for (int i = 1; i <=n/2 ; i++) {
                sum += 2*i-1;
            }
        }
        return sum;
    }

    // 3 min-max 问题
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int max = 0;
        int l = 0,r = position[position.length-1]-position[0];
        int mid;
        while (l<=r){
            mid = (l+r)>>1;
            if(check(mid,m,position)) l = mid+1;
            else r = mid-1;
        }
        return r;
    }

    public static boolean check(int d,int m,int[] arr){
        int pos = 0;
        int dis = arr[0] + d;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i] < dis) continue;
            pos++;
            dis = arr[i] + d;
        }
        return pos >= m;
    }


    // 4
    Map<Integer, Integer> map = new HashMap();
    public int minDays(int n) {
        if(n == 0) return 0;
        if(!map.containsKey(n)){
            int ans = n;
            int half = n / 2;
            int third = n / 3;
            ans = Math.min(ans, minDays(half) + 1 + n - half * 2);
            ans = Math.min(ans, minDays(third) + 1 + n - third * 3);
            map.put(n, ans);
        }
        return map.get(n);
    }


    public static void main(String[] args) {

    }
}
