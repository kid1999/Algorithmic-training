package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @title: P1495
 * @date 2019/11/12 20:33
 */

public class P1495 {
	static boolean flag;
	static long d, x, y;
	static long result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a1, m1, m2, a2, k;
		k = sc.nextLong();
		for (int i = 0; i <k ; i++) {
			m1 = sc.nextLong();
			a1 = sc.nextLong();
			k -= 1;
			flag = false;
			result = 0;
			x = y = 0;
			d = 0;
			for (int i = 0; i < k; i++) {
				m2 = sc.nextLong();
				a2 = sc.nextLong();
				long b = a2 - a1;
				d = extend_GCD(m1, m2);
				if (b % d != 0)
					flag = true;// 不存在整数解
				result = (x * (b / d) % m2 + m2) % m2;
				a1 = a1 + m1 * result; // 对于求多个方程
				m1 = (m1 * m2) / d; // lcm(m1,m2)最小公倍数；d是m1 和 m2 的最大公约数
				a1 = (a1 % m1 + m1) % m1;
			}
			if (flag)
				System.out.println(-1);
			else
				System.out.println(a1);
		}

	}

	// 扩展的欧几里德
	private static long extend_GCD(long a, long b) {
		long ret, t;
		if (b == 0) {
			x = 1;
			y = 0;
			return a;
		}
		ret = extend_GCD(b, a % b);
		t = x;
		x = y;
		y = t - (a / b) * y;
		return ret;
	}
}
