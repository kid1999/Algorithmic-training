package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @title: P1495
 * @date 2019/11/12 20:33
 */

public class P1495 {

	public static void main(String[] args) {
		// 输入数据
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long nums[] = new long[n+1];
		long mod[] = new long[n+1];
		for (int i = 0; i <n ; i++) {
			nums[i] = sc.nextInt();
			mod[i] = sc.nextInt();
		}
		// 用 同余的 加法 性质 统计出 sum(ai)
		// 其中 ai = 除i以外的num相加 得lcm_num 再用lcm_num*n mod num[i] == mod[i]
		long res = 0;
		for (int i = 0; i <n ; i++) {
			long lcm_num = 1;
			for (int j = 0; j <n ; j++) {
				if(j == i) continue;
				lcm_num = lcm(lcm_num,nums[j]);
			}
			int k = 1;
			while (true){
				if(lcm_num*k % nums[i] == mod[i]){
					res += lcm_num*k;
					break;
				}
				k++;
			}
		}
		// 计算出 最小公倍数
		long stander = 1;
		for (int i = 0; i <n ; i++) {
			stander = lcm(stander,nums[i]);
		}
		// 逼近最小的 结果
		while (res - stander >= 0){
			res -= stander;
		}
		System.out.println(res);
	}
	public static long gcd(long a,long b){
		return a == 0 ? b : gcd(b%a, a);
	}
	public static long lcm(long a,long b){
		return (a*b)/gcd(a,b);
	}


}