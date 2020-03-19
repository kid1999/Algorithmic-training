package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/19 10:51
 **/
public class T582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0,sum = 0;
        int l;
        for (int i = 0; i <m ; i++) {
            sum += arr[i];
        }
        max = sum;
        for (l=0; l <n ; l++) {
            sum = sum - arr[l] + arr[(l+m)%n];
            max = max >= sum ? max : sum;
        }
        System.out.println(max);
    }
}
