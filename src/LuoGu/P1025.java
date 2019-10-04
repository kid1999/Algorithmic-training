package LuoGu;

import java.util.Scanner;

public class P1025 {
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		dfs(1,n,k);
		System.out.println(res);
	}
	//	last 保证这次选的数 不会比上次小 造成重复
	public static void dfs(int last,int num,int k){
		if(k == 0){
			if(num == 0) res++;
			return;
		}
		// k 个 last 的值要小于 剩余的num
		for (int i = last; i*k <=num ; i++) {
			dfs(i,num-i,k-1);
		}
	}
}
