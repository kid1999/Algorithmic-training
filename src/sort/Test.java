package sort;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i <n ; i++) {
			nums[i] = sc.nextInt();
		}
		int num = sc.nextInt();
		int i;
		for (i = 0; i <n ; i++) {
			if(num == nums[i]){
				System.out.println(i+1);
				break;
			}
		}
		if(i>=n) System.out.println(-1);

	}

}
