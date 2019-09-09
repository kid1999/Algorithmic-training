package july.LeetCode;

import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		// a^b mode p
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			long a = sc.nextLong();
			long b = sc.nextLong();
			long p = sc.nextLong();
			func(a,b,p);
		}

	}

	public static void func(long a,long b,long p){
		long res = 1,t = a;
		while(b>0){
			if((b&1) == 1) res = res * t % p;
			t = t * t % p;
			b >>= 1;
		}
		System.out.println(res);
	}
}