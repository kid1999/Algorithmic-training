package CF.R589.world5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
	private static class Node{
		int x;
		int y;
		int z;
		int index;

		public Node(int x, int y, int z, int index) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.index = index;
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node[] dp = new Node[n];
		Node[] tmp = new Node[n];
		for (int i = 0; i <n ; i++) {
			dp[i] = new Node(sc.nextInt(),sc.nextInt(),sc.nextInt(),i);
			tmp[i] = new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,-1);
		}
		for (int i = 0; i <n ; i++) {
			for (int j = 0; j <n ; j++) {
				if(i == j) continue;
				if(tmp[j].index == -1) tmp[j] = dp[j];
				if((dp[j].x < Math.max(dp[i].x,tmp[i].x)) && (dp[j].x > Math.min(dp[i].x,tmp[i].x)) &&(dp[j].y < Math.max(dp[i].y,tmp[i].y)) && (dp[j].y > Math.min(dp[i].y,tmp[i].y)) && (dp[j].z < Math.max(dp[i].z,tmp[i].z)) && (dp[j].z > Math.min(dp[i].z,tmp[i].z))){
					tmp[i] = dp[j];
				}
			}
		}
		Set<Node> set = new HashSet<>();
		for (int i = 0; i <n ; i++) {
			if(!set.contains(dp[i])){
				System.out.println(i +" " + tmp[i].index);
				set.add(tmp[i]);
			}
		}
	}
}
