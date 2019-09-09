package baidu;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][2];
			for(int j = 0;j<n;j++){
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
		}
	}
}
