package LuoGu;

import java.util.*;

public class P1579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] dp = new boolean[20001];
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <=sqrt ; i++) {
			if(!dp[i]){
				for (int j = i*i; j <=n ; j+=i) {
					dp[j] = true;
				}
			}
		}
		for (int i = 2; i <=n ; i++) {
			if(!dp[i]){
				list.add(i);
				set.add(i);
			}
		}
		
		// 暴力
		for (int i = 0; i <list.size() ; i++) {
			for (int j = 0; j <list.size() ; j++) {
				int a = list.get(i);
				int b = list.get(j);
				if (a+b>=n) break;
				if(set.contains(n-a-b)){
					if(a<b) System.out.println(a + " " + b + " " + (n-a-b));
				  else System.out.println(b + " " + a + " " + (n-a-b));
				  return;
				}
			}
		}
	}
}
