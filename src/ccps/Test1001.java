package ccps;

import java.util.Scanner;

public class Test1001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i <t ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int s = Math.min(a,b);
			int c = 0;
			int dp[] = new int[32];
			while (a>0 || b>0){
				if ((a&1)==1 && (b&1)==1) dp[c++] = 1;
				else dp[c++] = 0;
				a>>= 1;
				b>>= 1;
			}
			int res = 0 ;
			for(int j=31;j>=0;j--){
				res |= dp[j];
				res<<=1;
			}
			res >>= 1;
			if(res == 0) System.out.println(s);
			else System.out.println(res);
		}
	}
}
