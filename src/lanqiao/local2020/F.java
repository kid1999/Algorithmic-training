package lanqiao.local2020;

import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n+1];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		int max = 1;
		int len = 1;
		int num = nums[0];
		for(int i=1;i<n;i++){
			if(num<nums[i]) len++;
			else len = 1;
			num = nums[i];
			if(len > max ) max = len;
		}
		System.out.println(max);
	}
}
