package lanqiao;

import java.util.Scanner;

public class F {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    int res = 0;
    for (int i = 1; i <=n ; i++) {
      if(containsNum(i)) res+=i;
    }
    System.out.println(res);
  }
  public static boolean containsNum(int n){
    while (n>0){
      int tmp = n%10;
      n/=10;
      if(tmp==1||tmp==2||tmp==0||tmp==9) return true;
    }
    return false;
  }
}
