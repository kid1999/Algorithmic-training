package LuoGu;

import java.util.Scanner;

public class P1433 {
	private static double[][] nums;
	private static boolean[] vis;
	private static double res = Double.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nums = new double[n][2];
		vis = new boolean[n];
		for (int i = 0; i <n ; i++) {
			nums[i][0] = sc.nextDouble();
			nums[i][1] = sc.nextDouble();
		}
		dfs(0,0,n,0);
		System.out.printf("%.2f",res);
	}
	public static double compute(double x1,double y1,double x2,double y2){
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}

	public static void dfs(double x1,double y1,int count,double sum){
		if (sum > res) return;
		if(count == 0){
			res = Math.min(sum,res);
			return;
		}
		for (int i = 0; i <nums.length ; i++) {
			if(!vis[i]){
				vis[i] = true;
				dfs(nums[i][0],nums[i][1],count-1,sum + compute(x1,y1,nums[i][0],nums[i][1]));
				vis[i] = false;
			}
		}
	}
}
