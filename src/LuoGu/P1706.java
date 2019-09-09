package LuoGu;

import java.util.Scanner;

public class P1706 {
    static int n;
    static int[] box = new int[15];
    static int[] vis = new int[15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            box[i] = i+1;
        }
        dfs(0);

    }

    static void dfs(int step){
        if (step == n){
            for (int i = 0; i <n ; i++) {
                System.out.printf("%5d",box[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <=n ; i++) {
            if(vis[i]==0){
                box[step] = i;
                vis[i] = 1;
                dfs(step+1);
                vis[i] = 0;
            }
        }

    }



















//        sort_print(arr,0);
//    }
//
//    public static void sort_print(int[] data,int i){
//        if (i == data.length){
//            for (int j = 0; j < data.length; j++) {
//                System.out.printf("%5d",data[j]);
//            }
//            System.out.println();
//        }
//
//
//        for (int j = i; j < data.length; j++) {
//            // swap
//            {
//                int t = data[j];
//                data[j] = data[i];
//                data[i] = t;
//            }
//            sort_print(data,j+1);
//            // swap back
//            {
//                int t = data[j];
//                data[j] = data[i];
//                data[i] = t;
//            }
//        }




}
