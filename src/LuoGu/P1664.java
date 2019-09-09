package LuoGu;

import java.util.Scanner;


public class P1664 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int res= 0;
    int days = 0;
    int undays = 0;
    for (int i = 0; i <n ; i++) {
      int flag = sc.nextInt();
      if(flag == 1){
        if(undays>=1){
          days -= Math.pow(2,(undays-1));
          if(days <1) days = 0;
          undays = 0;
        }
        days++;
        if(days<3) res += 1;
        else if(days<7) res += 2;
        else if(days<30) res += 3;
        else if(days<120) res += 4;
        else if(days<365) res += 5;
        else  res += 6;
      }
      else{
        undays++;
      }
    }
    System.out.println(res);
  }
}
