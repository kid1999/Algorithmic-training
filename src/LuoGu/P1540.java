package LuoGu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1540 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i <n ; i++) {
			int word = sc.nextInt();
			if(!queue.contains(word)){
				queue.offer(word);
				count++;
			}
			if(queue.size() > m) queue.poll();
		}
		System.out.println(count);
	}
}
