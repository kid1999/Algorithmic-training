package may;

import java.util.Scanner;

public class P1048 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int w = sc.nextInt();
    int n = sc.nextInt();
    int[] weight = new int[n+1];
    int[] value = new int[n+1];
    for (int i = 1; i <=n ; i++) {
      weight[i] = sc.nextInt();
      value[i] = sc.nextInt();
    }

    // 处理背包
    int[][] B = new int[n+1][w+1];
    for (int k = 1; k <=n ; k++) {  //第k个物品
      for (int c = 1; c <=w ; c++) {  // 背包剩余容量
        if(weight[k] > c){
          B[k][c] = B[k-1][c];  // 超重
        }else {
          int v1 = B[k-1][c-weight[k]] + value[k];  //选
          int v2 = B[k-1][c];  // 不选
          B[k][c] = Math.max(v1,v2);
        }
      }
    }
    System.out.println(B[n][w]);
  }
}
