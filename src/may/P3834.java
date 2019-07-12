package may;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class P3834 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[n+1];
		for (int i = 1; i <=n ; i++) {
			nums[i] = sc.nextInt();
		}
		// start
		for (int i = 0; i <m ; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			int k = sc.nextInt();
			PriorityQueue<Integer> q=new PriorityQueue<Integer>(10, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			for (int j = left; j <=right ; j++) {
				if(q.size()<k) q.offer(nums[j]);
				else {
					if(q.peek() > nums[j]){
						q.poll();
						q.offer(nums[j]);
					}
				}
			}
			System.out.println(q.peek());
		}
	}
}
