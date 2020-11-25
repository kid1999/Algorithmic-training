package lanqiao.test2019_f;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-11-13 14:07
 * @description TODO
 **/
public class B {
    static ArrayList<Integer> list;
    static int ans = 0;
    static long arr[][] = new long[5555][500];
    public static void main(String[] args) {
        func();
        for(int i=0;i<2020;i++){
            for(int j=0;j<500;j++){
                arr[i][j] = -1;
            }
        }
        arr[1][1] = 1;
//        dfs(0,0,new ArrayList<>());
        long res = dfs(0,55,new ArrayList<>());
        System.out.println(res);
    }

    public static long dfs(int sum,int i,ArrayList<Integer> tmp){
        if(arr[sum][i] != -1) return arr[sum][i];
        if(sum == 2019){
            //if(ans % 10000 == 0) System.out.println(tmp);
            System.out.println(tmp);
            return 1;
        }
        if(sum > 2019 || i>=list.size()) return 0;
        tmp.add(list.get(i));
        long t1 = 0;
        t1 += dfs(sum+list.get(i),i+1,tmp);
        tmp.remove(tmp.size()-1);
        //tmp.add(list.get(i));
        t1 += dfs(sum,i+1,tmp);
        //tmp.remove(tmp.size()-1);
        arr[sum][i] = t1;
        return arr[sum][i];
    }



    public static void func(){
        list = new ArrayList<>();
        for (int i = 2; i <3000 ; i++) {
            boolean f = false;
            for (int j = 2; j <i ; j++) {
                if(i%j == 0) f = true;
            }
            if(!f) list.add(i);
        }
    }

}