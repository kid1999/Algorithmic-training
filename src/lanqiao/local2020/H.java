package lanqiao.local2020;

import java.util.Scanner;

public class H {
	static int res = 0;
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		for(int i=1;i<=n;i++){
			dfs(2,i);
		}
		System.out.println(res);
	}
	
	public static void dfs(int index,int pre){
		if(index == m+1){
			res++;
			return;
		}
		if(index % 2 == 0){
			for(int i=1;i<pre;i++){
				dfs(index+1,i);
			}
		}else{
			for(int i=pre+1;i<=n;i++){
				dfs(index+1,i);
			}
		}
	}
}
