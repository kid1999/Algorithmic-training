package luogu;

import java.util.Scanner;

public class P1149 {
	static int res = 0;
	static int[] fire = new int[1001];
	static int[] nums = new int[4];
	static int fire_num = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		fire_num = sc.nextInt() - 4;
		int [] nums = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
		for (int i = 0; i < nums.length; i++) {
			fire[i] = nums[i];
		}
		// 构造2-3位数 火柴数
		for (int i = 10; i < 1000; i++) {
			fire[i] = fire[i/10] + fire[i%10];
		}	
		func(1);
		System.out.println(res);
	}
	// 构建满足火柴的条件
	public static void func(int index) {
		for(int i=0;i<1000;i++) {
			if(fire_num>=fire[i]) {
				nums[index] = i;
				fire_num -= fire[i];
				if(index == 3) {
					if(nums[1] + nums[2] == nums[3] && fire_num == 0) res++;
				}
				else func(index+1);
				fire_num += fire[i];
			}
		}
	}

}
