package CF.R593;

import java.util.Scanner;

public class Main3 {
  private static int[][] res;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    res = new int[n+1][n+1];
    boolean f = true;
    for (int i = 0; i <n ; i++) {   // 列
      if(f){
        for (int j = 1; j <=n ; j++) {
          res[j][i] = i*n+j;
        }
      }else{
        for (int j = 1; j <=n ; j++) {
          res[n-j+1][i] = i*n+j;
        }
      }
      f = !f;
    }

    for (int i = 1; i <=n ; i++) {
      for (int j = 0; j <n ; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }


  }
}
