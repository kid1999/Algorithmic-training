package HDOJ;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-11-19 20:45
 * @description TODO
 **/
public class P1026 {
    static int minD;
    static LinkedList<info> res;
    static int[] f = {0,1,0,-1,1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            minD = Integer.MAX_VALUE;
            res = null;
            String nm = sc.nextLine();
            if(nm.equals("1")) return;
            int n = Integer.valueOf(nm.split(" ")[0]);
            int m = Integer.valueOf(nm.split(" ")[1]);
            int[][] arr = new int[n][m];
            for (int i = 0; i <n ; i++) {
                String s = sc.nextLine();
                for (int j = 0; j <s.length() ; j++) {
                    char c = s.charAt(j);
                    if(c == '.') arr[i][j] = 0;
                    else if(c == 'X') arr[i][j] = -1;
                    else arr[i][j] = c - '0';
                }
            }
            dfs(arr,0,0,0,new LinkedList<info>());
            for (info f : res){
                System.out.println(f);
            }
        }
    }
    public static void dfs(int[][] arr, int i, int j, int d, LinkedList<info> list){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] == -1) return;
        if(i == arr.length-1 && j == arr[0].length-1){
            if(d < minD) res = list;return;
        }
        for (int k = 0; k <4 ; k++) {
            list.add(new info(i,j,d,arr[i][j]));
            int t = arr[i][j];
            arr[i][j] = -1;
            int nd = arr[i][j] == 0 ? d+1 : d+arr[i][j];
            dfs(arr,i+f[2*k],j+f[2*k+1],nd,list);
            arr[i][j] = t;
            list.removeLast();
        }

    }


    static class info{
        int i;
        int j;
        int d;
        int x;
        public info() { }

        public info(int i, int j, int d, int x) {
            this.i = i;
            this.j = j;
            this.d = d;
            this.x = x;
        }

        @Override
        public String toString() {
            return "info{" +
                    "i=" + i +
                    ", j=" + j +
                    ", d=" + d +
                    ", x=" + x +
                    '}';
        }
    }
}