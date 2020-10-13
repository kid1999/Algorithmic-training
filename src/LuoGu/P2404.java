package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-10-13 14:21
 * @description TODO
 **/
public class P2404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(n,"",1);
    }

    public static void dfs(int num,String s,int last){
        if(num == 0) {
            String res = s.substring(1);
            if(res.length() != 1) System.out.println(res);
            return;
        }
        for (int i = last; i <=num ; i++) {
            dfs(num-i,s+"+"+i,i);
        }
    }
}