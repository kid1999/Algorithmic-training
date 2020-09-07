package LeetCode;

import javafx.util.Pair;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/7/19 10:28
 **/
public class week198 {
    public static void main(String[] args) {

    }

    // 1
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles>=numExchange){
            int exange = numBottles / numExchange;
            res += exange;
            numBottles = numBottles - (exange * numExchange) + exange;
        }
        return res;
    }

//    // 2
//    class Tree{
//        int id;
//        int[] words = new int[26];
//        List<Integer> son = new ArrayList<>();
//        public Tree(int id) {
//            this.id = id;
//        }
//    }
//
//    public int[] countSubTrees(int n, int[][] edges, String labels) {
//        Arrays.sort(edges, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]) return o1[1]-o2[1];
//                else return o1[0]-o2[0];
//            }
//        });
//        Tree[] trees = new Tree[n];
//    }
//
//    void BuildTree(int n, int[][] edges, String labels,Tree[] trees){
//
//    }
//
//    // 3
//    public List<String> maxNumOfSubstrings(String s) {
//        int max = 0;
//        int len = Integer.MAX_VALUE;
//        Pair<Integer,Integer>[] words = new Pair[26];
//        for (int i = 0; i <26 ; i++) {
//            int l = s.indexOf('a'+i);
//            int r = s.lastIndexOf('a'+i);
//            words[i] = new Pair<>(l,r);
//        }
//        for (int i = 0; i <26 ; i++) {
//            Pair<Integer,Integer> p = words[i];
//            while ()
//            for (int j = 0; j <26 ; j++) {
//                Pair<Integer,Integer> w = words[j];
//                if(p.getValue() < w.getKey())
//            }
//        }
//
//    }
//
//    // 4
//    public int closestToTarget(int[] arr, int target) {
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i <arr.length ; i++) {
//            for (int j = i; j <arr.length ; j++) {
//                min = Math.min(min,func(i,j,target,arr));
//            }
//        }
//        return min;
//    }
//    int func(int l,int r,int target,int[] arr){
//        int res = arr[l];
//        if(r<l) res = -1000000000;
//        for (int i = l+1; i <=r ; i++) {
//            res &= arr[i];
//        }
//        return Math.abs(res-target);
//    }
}
