package nowcoder.bytedance;

/**
 * @author kid1999
 * @date 2020/9/20 19:00
 * @title Main
 */

import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String nn = sc.nextLine();
		int n = Integer.parseInt(nn);
		for(int i=0;i<n;i++){
			String s = sc.nextLine();
			String[] strs = s.split(" ");
			long res;
			long mod = 1000000007;
			long a = Long.parseLong(strs[0]) % mod;
			long b = Long.parseLong(strs[1]) % mod;
			String op = strs[2];
			if(op.equals("+")){
				res = (a+b)%mod;
			}else if(op.equals("-")){
				res = (a-b)%mod;
			}else if(op.equals("*")){
				res = (a*b)%mod;
			}else{
				res = 1;
				long t = a;
				while (b>0){
					if((b&1) == 1){
						res = res * t % mod;
					}
					t = t * t % mod;
					b = b >> 1;
				}
			}
			System.out.println(res);
		}
	}
}