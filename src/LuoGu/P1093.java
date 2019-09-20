package LuoGu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1093 {
	static class Node{
		int id;
		int chinese;
		int sum;
		public Node(int id, int chinese, int sum) {
			this.id = id;
			this.chinese = chinese;
			this.sum = sum;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node[] nodes = new Node[n];
		for (int i = 1; i <=n ; i++) {
			int chinese = sc.nextInt();
			int math = sc.nextInt();
			int english = sc.nextInt();
			int sum = chinese + math + english;
			nodes[i-1] = new Node(i,chinese,sum);
		}

		Arrays.sort(nodes,new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				if(o2.sum > o1.sum) return 1;
				else if(o2.sum < o1.sum) return -1;
				else{
					if(o2.chinese > o1.chinese) return 1;
					else if(o2.chinese < o1.chinese) return -1;
					else return o1.id - o2.id;
				}
			}
		});
		for (int i = 0; i <5 ; i++) {
			System.out.println(nodes[i].id + " " + nodes[i].sum);
		}
	}
}
