package CF.R589.world5;

import java.util.*;

public class Mian2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> in = new LinkedList<>();
		Queue<Integer> out = new LinkedList<>();
		for (int i = 0; i <n ; i++) {
			in.offer(sc.nextInt());
		}
		for (int i = 0; i <n ; i++) {
			out.offer(sc.nextInt());
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i <n ; i++) {
			int car = out.poll();
			int head = in.peek();
			while (set.contains(head)){
				in.poll();
				head = in.peek();
			}
			if (car == head) in.poll();
			else set.add(car);
			}
		System.out.println(set.size());
	}
}
