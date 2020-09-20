package nowcoder.bytedance;

import java.util.Scanner;

/**
 * @author kid1999
 * @date 2020/9/20 19:51
 * @title C
 */

public class C {
//	public static void main(String[] args) {
//		Scanner sc  = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int[][] p = new int[n][2];
//		int[][] d = new int[n][2];
//		for (int i = 0; i <n ; i++) {
//			p[i][0] = sc.nextInt();
//			p[i][1] = sc.nextInt();
//		}
//		for (int i = 0; i <m ; i++) {
//			d[i][0] = sc.nextInt();
//			d[i][1] = sc.nextInt();
//		}
//		double minDistance = Integer.MAX_VALUE;
//		double[] sum = {0,0};
//		for (int i = 0; i < n ; i++) {
//			sum[0] += p[i][0];
//			sum[1] += p[i][1];
//		}
//		double[] center = {sum[0] / n ,sum[1] / n};
//		int[] res = {0,0};
//		for (int i = 0; i <m ; i++) {
//			double dis = getDistance(center[0],d[i][0],center[1],d[i][1]);
//			if(minDistance > dis){
//				minDistance = dis;
//				res[0] = d[i][0];
//				res[1] = d[i][1];
//			}
//		}
//		System.out.println(res[0] + " " + res[1]);
//	}



	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] p = new int[n][2];
		for (int i = 0; i <n ; i++) {
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
		}
		double minDistance = Integer.MAX_VALUE;
		int[] res = {0,0};
		for (int i = 0; i <m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			double min = 0;
			for (int j = 0; j <n ; j++) {
				double dis = getDistance(p[j][0],a,p[j][1],b);
				min += dis;
			}
			if(min < minDistance) {
				minDistance = min;
				res[0] = a;
				res[1] = b;
			}
		}
		System.out.println(res[0] + " " + res[1]);
	}

	public static double getDistance(double x1,double x2,double y1,double y2){
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}
