package LuoGu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1583 {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] adds = new int[11];
		for (int i = 1; i <=10 ; i++) {
			adds[i] = sc.nextInt();
		}
		Node[] dp = new Node[n];
		for (int i = 0; i <n ; i++) {
			dp[i] = new Node(i+1,sc.nextInt());
		}
		Arrays.sort(dp,new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return o2.y - o1.y;
			}
		});
		for (int i = 0; i <n ; i++) {
			dp[i].y += adds[i%10+1];
		}
		Arrays.sort(dp,new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				if(o2.y > o1.y) return 1;
				else if(o2.y < o1.y) return -1;
				else{
					return o1.x - o2.x;
				}
			}
		});
		for (int i = 0; i <k ; i++) {
			System.out.print(dp[i].x + " ");
		}

	}
}
