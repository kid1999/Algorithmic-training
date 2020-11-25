package lanqiao.final2020;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-11-14 19:56
 * @description TODO
 **/
public class F {
    static class node{
        int head;
        int sum;

        public node(int head, int sum) {
            this.head = head;
            this.sum = sum;
        }

        public node() {
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        node[] nodes = new node[n+1];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            nodes[i] = new node(a+b,a+b+c);
        }
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <i ; j++) {
                dp1[j] = dp2[j] + nodes[j].head;
                dp2[j] = dp2[j] + nodes[j].sum;
            }
        }
    }
}