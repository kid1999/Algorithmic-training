package LuoGu;

import java.util.Scanner;

public class P1087 {
  static char[] chars;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    chars = sc.next().toCharArray();
    func(0,(1<<n)-1);
  }
  public static void func(int l,int r){
    if(l<r){
      int mid = (l+r)/2;
      func(l,mid);
      func(mid+1,r);
    }
    boolean B=false,I=false;
    for (int i = l; i <=r ; i++) {
      if(chars[i] == '0') B=true;
      else if(chars[i] == '1') I=true;
    }
    if(B&&I) System.out.print('F');
    else if(I) System.out.print("I");
    else System.out.print("B");
  }
}
