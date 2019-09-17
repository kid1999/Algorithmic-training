package LuoGu;

import java.util.Arrays;
import java.util.Scanner;

class Node implements Comparable<Node>{
	int price;
	int count;

	public Node(int price, int count) {
		this.price = price;
		this.count = count;
	}

	@Override
	public int compareTo(Node other) {
		return this.price - other.price;
	}
}

public class P1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Node[] dp = new Node[m];
		for (int i = 0; i <m ; i++) {
			dp[i] = new Node(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(dp);
		int res = 0;
		for (Node node:dp) {
			if(node.count >= n){
				res += n*node.price;
				break;
			}else{
				res += node.count*node.price;
				n -= node.count;
			}
		}
		System.out.println(res);
	}
}
