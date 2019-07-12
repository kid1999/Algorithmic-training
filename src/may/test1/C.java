package may.test1;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i <t ; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] money = new int[n];
            for (int j = 0; j < n; j++) {
                money[j] = sc.nextInt();
            }
            Arrays.sort(money);
            int j;
            for (j = 0; j <money.length ; j++) {
                if(money[k]<k){
                  break;
                }
                if(money[k]==k){
                    System.out.println("Yes");
                    break;
                }
            }
            int left = 0;
            int right = j;
            for (int l = 0; l <= right; l++) {
                if(money[left] + money[right] > k){
                    right --;
                }
            }

        }
    }
}
