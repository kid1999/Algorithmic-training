package LuoGu;

import java.util.Scanner;

public class P1605 {
  static boolean[][] flag;
  static boolean[][] tmp;
  static int[] aim;
  static int[] fun;
  static int res = 0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int t = sc.nextInt();
    aim = new int[4];
    fun = new int[]{0,-1,0,1,1,0,-1,0};
    flag = new boolean[n][m];
    tmp = new boolean[n][m];
    for (int i = 0; i <4 ; i++) {
      aim[i] = sc.nextInt() - 1;
    }
    for (int i = 0; i < t; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      flag[a-1][b-1] = true;
    }
    DFS(aim[0],aim[1]);
    System.out.println(res);
  }
  private static void DFS(int i,int j){
    if(flag[i][j]) return;
    if(i==aim[2] && j == aim[3]){
      res++;
      return;
    }
      for (int k = 0; k <4 ; k++) {
      if(i+fun[2*k] >= 0 && i+fun[2*k] < flag.length && j+fun[2*k+1] < flag[0].length && j+fun[2*k+1] >=0){
        if(!tmp[i+fun[2*k]][j+fun[2*k+1]] && !flag[i+fun[2*k]][j+fun[2*k+1]]){
          tmp[i][j] = true;
          DFS(i+fun[2*k],j+fun[2*k+1]);
          tmp[i][j] = false;
        }
      }
    }
    return;
  }
}
