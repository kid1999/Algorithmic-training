package acWing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/1 9:25
 **/
public class 混合背包 {

    private static class Thing{
        int kind;   // 种类
        int weight;  // 重量
        int value;   // 价值
        Thing(int kind,int weight,int value){
            this.kind = kind;
            this.value = value;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        List<Thing> things = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            int count = sc.nextInt();
            if(count < 0) things.add(new Thing(-1,weight,value));       // 01背包
            else if(count == 0) things.add(new Thing(0,weight,value));  // 完全背包
            else{                                                            // 多重背包
                for (int j = 1; j <=count ; j*=2) {
                    count -= j;
                    things.add(new Thing(-1,weight*j,value*j));
                }
                if(count > 0) things.add(new Thing(-1,weight*count,value*count));
            }
        }

        int[] dp = new int[w+1];
        for (Thing thing:things) {
            if(thing.kind < 0){
                for (int j = w; j >=thing.weight ; j--) dp[j] = Math.max(dp[j],dp[j-thing.weight]+thing.value);
            }else{
                for (int j = thing.weight; j <= w ; j++) dp[j] = Math.max(dp[j],dp[j-thing.weight]+thing.value);
            }
        }
        System.out.println(dp[w]);
    }
}
