package LuoGu;

import java.util.Scanner;

public class P1219 {
  static boolean[] b,c,d; // 分别是 列 行 上斜 反斜
  static int[] a;
  static int n,res=0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    a = new int[100];
    b = new boolean[100];
    c = new boolean[100];
    d = new boolean[100];
    DFS(1);
    System.out.println(res);
  }
  private static void DFS(int i){
    if(i>n){
      if(res <= 2){
        for (int j = 1; j <=n ; j++) {
          System.out.print(a[j] + " ");
        }
        System.out.println();
      }
      res++;
      return;
    }else{
      for (int j = 1; j <=n ; j++) {
        if(!b[j] && !c[i+j] && !d[i+n-j]){ // 这里很巧妙的表达了 行 上斜 下斜的表示
          a[i] = j; // 存储答案
          b[j] = true;
          c[i+j] = true;
          d[i+n-j] = true;
          DFS(i+1);   // i+1行
          b[j] = false;   // 还原现场，搜索下一个可能性
          c[i+j] = false;
          d[i+n-j] = false;
        }
      }
    }
  }

}
