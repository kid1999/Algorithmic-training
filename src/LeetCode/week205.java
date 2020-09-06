package LeetCode;

import java.util.*;

/**
 * @author kid1999
 * @date 2020/9/6 10:19
 * @desc
 **/
public class week205 {

    // 1
    public String modifyString(String s) {
        String res = "";
        if(s.equals("?")) return "a";
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '?'){
                if(i == 0){
                    for (int j = 0; j <26 ; j++) {
                        if('a' + j != s.charAt(i+1)){
                            res += (char)('a'+j);break;
                        }
                    }
                }else if(i == s.length()-1){
                    for (int j = 0; j <26 ; j++) {
                        if('a' + j != res.charAt(i-1)){
                            res += (char)('a'+j);break;
                        }
                    }
                }else {
                    for (int j = 0; j <26 ; j++) {
                        if('a' + j != res.charAt(i-1) && 'a' + j != s.charAt(i+1)){
                            res += (char)('a'+j);break;
                        }
                    }
                }
            }else {
                res += c;
            }
        }
        return res;
    }

    // 2
    public static int numTriplets(int[] nums1, int[] nums2) {
        HashMap<Long,Integer> map = new HashMap<>();
        HashMap<Long,Integer> map2 = new HashMap<>();
        int res = 0;
        for (int n:nums1) {
            long num = (long)n*n;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int i = 0; i <nums2.length ; i++) {
            for (int j = i+1; j <nums2.length ; j++) {
                long num = (long) nums2[i] *  nums2[j];
                res += map.getOrDefault(num,0);
            }
        }

        for (int n:nums2) {
            long num = (long)n*n;
            map2.put(num,map2.getOrDefault(num,0)+1);
        }
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = i+1; j <nums1.length ; j++) {
                long num = (long) nums1[i] *  nums1[j];
                res += map2.getOrDefault(num,0);
            }
        }
        return res;
    }

    // 3
    public static int minCost(String s, int[] cost) {
        int res = 0;
        int len = cost.length, l = 0, r = 0;
        while (r<len){
            while (r<len && s.charAt(l) == s.charAt(r)){
                r++;
            }
            if(r >= len) break;
            if(r-l>1){
                int sum = 0,max = Integer.MIN_VALUE;
                for (int i = l; i <r ; i++) {
                    sum += cost[i];
                    max = Math.max(max,cost[i]);
                }
                res += (sum - max);
                l = r;
            }else {
                l++;
            }
        }
        if(r-l>1){
            int sum = 0,max = Integer.MIN_VALUE;
            for (int i = l; i <r ; i++) {
                sum += cost[i];
                max = Math.max(max,cost[i]);
            }
            res += (sum - max);
            l = r;
        }
        return res;
    }


    // 4
//    public int maxNumEdgesToRemove(int n, int[][] edges) {
//        int res = 0;
//        int[][] edge = new int[n][n];
//        for (int[] arr : edges) {
//            if (edge[arr[1]][arr[2]] != 0) res++;
//            if (arr[0] == 3) {
//                edge[arr[1]][arr[2]] = 3;
//                if (arr[0] == 2) edge[arr[1]][arr[2]] = 2;
//                if (arr[0] == 1) edge[arr[1]][arr[2]] = 1;
//            }
//
//        }
//        return res;
//    }


    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        int res = 0;
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] arr:edges) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
        return res;
    }
    public static void main(String[] args) {
//        int[] arr = {43024 ,99908};
//        int[] arr2 = {1864};
//        System.out.println(numTriplets(arr,arr2));

        int[] arr = {1,2,3,4,5};
        System.out.println(minCost("abaac",arr));
    }
}
