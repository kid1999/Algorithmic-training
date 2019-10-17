package CF.R593;

import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int m = sc.nextInt();
//    int res = 0;
//    for (int i = 0; i <n ; i++) {
//
//    }
    System.out.println(C(1,2));


  }


  // 求排列数 A(n,m) n>m
  public static int A(int n, int m) {
    int result = 1;
    // 循环m次,如A(6,2)需要循环2次，6*5
    for (int i = m; i > 0; i--) {
      result *= n;
      n--;// 下一次减一
    }
    return result;
  }

  public static int C(int n, int m)// 应用组合数的互补率简化计算量
  {
    int helf = n / 2;
    if (m > helf) m = n - m;
    // 分子的排列数
    int numerator = A(n, m);
    // 分母的排列数
    int denominator = A(m, m);
    return numerator / denominator;
  }

}
