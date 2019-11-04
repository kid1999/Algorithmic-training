package LuoGu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean[] check = new boolean[b+1]; //     检查数组
		List<Integer> list = new ArrayList<>();
		int sqrt = (int) Math.sqrt(b);
		for(int i = 2;i<=sqrt;i++) {
			if(!check[i]) {
				for (int j = i*i; j <=b ; j+=i) {
					check[j] = true;
				}
			}
		}

		for(int i=a;i<=b;i++) {
			if(!check[i] && isHui(i)) {
				System.out.println(i);
			}
		}
	}
	public static boolean isHui(int num) {
		String s = String.valueOf(num);
		int l = 0, r = s.length()-1;
		while(l<r) {
			if(s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
}
