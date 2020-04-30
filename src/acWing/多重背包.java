package acWing;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/30 10:52
 **/
public class 多重背包 {
    // 朴素版
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int v = sc.nextInt();
//        int[] weight = new int[n+1];
//        int[] values = new int[n+1];
//        int[] counts = new int[n+1];
//        for (int i = 0; i <n ; i++) {
//            weight[i] = sc.nextInt();
//            values[i] = sc.nextInt();
//            counts[i] = sc.nextInt();
//        }
//        int[] dp = new int[v+1];
//        for (int i = 0; i <n ; i++) {
//            for (int j = v; j >= 0 ; j--) {
//                for (int k = 1; k<=counts[i] && k*weight[i] <= j ; k++) {
//                    dp[j] = Math.max(dp[j],dp[j-k*weight[i]]+k*values[i]);
//                }
//            }
//        }
//        System.out.println(dp[v]);
//    }

    // 优化版
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        List<Pair<Integer,Integer>> goods = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            int count = sc.nextInt();
            for (int j = 1; j <=count ; j*=2) {
                count -= j;
                goods.add(new Pair<>(weight*j,value*j));
            }
            if(count > 0) goods.add(new Pair<>(count*weight,count*value));
        }

        int[] dp = new int[w+1];
        for (Pair<Integer,Integer> good:goods) {
            for (int j = w; j >=good.getKey() ; j--) {
                dp[j] = Math.max(dp[j],dp[j-good.getKey()]+good.getValue());
            }
        }
        System.out.println(dp[w]);
    }
}
