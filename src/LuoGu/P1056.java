package LuoGu;

import java.util.*;

public class P1056 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int l = sc.nextInt();
		int d = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[m];
		for (int i = 0; i <d ; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			if(x1 == x2) y[Math.min(y1,y2)]++;
			if(y1 == y2) x[Math.min(x1,x2)]++;
		}
		int x_max = find(x,l);
		int y_max = find(y,k);
		int[] res_x = new int[l];
		int[] res_y = new int[k];
		int index = 0;
		for (int i = 0; i < x.length ; i++) {
			if(x[i] >= x_max && index < l) res_x[index++] = i+1;
		}
		index = 0;
		for (int i = 0; i < y.length ; i++) {
			if(y[i] >= y_max && index < k) res_y[index++] = i+1;
		}
		Arrays.sort(res_x);
		Arrays.sort(res_y);
		System.out.println(res_x.length + " "+ l);


		for (int num:res_y) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int num:res_x) {
			System.out.print(num + " ");
		}
	}

	public static int find(int[] nums,int max){
		PriorityQueue<Integer> q = new PriorityQueue();
		for (int n:nums) {
			if(q.size() < max) q.offer(n);
			else if(q.peek() < n){
				q.poll();
				q.offer(n);
			}
		}
		return q.peek();
	}

}
