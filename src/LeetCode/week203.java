package LeetCode;

import java.util.*;

/**
 * @auther: kid1999
 * @desc:
 * @date: 2020/8/23 10:17
 **/
public class week203 {


    // 1
    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int l = rounds[0];
        int r = rounds[rounds.length-1];
        if(l<=r){
            for (int i = l; i <=r ; i++) {
                res.add(i);
            }
        }else {
            for (int i = 1; i <=r ; i++) {
                res.add(i);
            }
            for (int i = l; i <=n ; i++) {
                res.add(i);
            }
        }
        return res;
    }

    // 2
    public int maxCoins(int[] piles) {
        int n = piles.length/3;
        Arrays.sort(piles);
        int i = piles.length-2;
        int count = 0;
        while (n > 0){
            count += piles[i];
            i-=2;
            n--;
        }
        return count;
    }

    // 3
    public static int findLatestStep(int[] arr, int m) {
        int last = -1;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            int index = arr[i];
            int len = 1;
            int l = map.getOrDefault(index-1,0);
            int r = map.getOrDefault(index+1,0);
            len = len+l+r;
            if(map.getOrDefault(index-l,0) == m) count--;
            if(map.getOrDefault(index+r,0) == m) count--;
            map.put(index-l,len);
            map.put(index+r,len);
            map.put(index,len);
            if(len == m){
                count++;
                last = i+1;
            }
            if(count >= 1) last = i+1;
        }
        return last;
    }

    // 4
//    public int stoneGameV(int[] stoneValue) {
//
//    }

    public static void main(String[] args) {
        int[] arr = {2,1};
        System.out.println(findLatestStep(arr,2));
    }
}
