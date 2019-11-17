package lanqiao.local2020;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = n;
		for(int i=1;i<=n;i++){
			if(func(i)) res--;
		}
		System.out.println(res);
	}
	public static boolean func(int num){
		boolean[] vis = new boolean[11];		//?
		while(num != 0){
			int n = num%10;
			if(vis[n]) return true;
			else vis[n] = true;
			num /= 10;
		}
		return false;
	}

}
