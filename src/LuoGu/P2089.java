package luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2089 {
	static int[][] res;
	static int count = 0;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(n<10 || n>30) {
			System.out.println("0");
			return;
		}
		res = new int[100000][11];
		print(0, 0);
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 10; j++) {
				if(res[i][j] == 0) res[i][j] = res[i-1][j];
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void print(int index,int sum) {
		if(index == 10) {
			if(sum == n) {
				count++;
			}
			return ;
		}
		for(int i=1;i<=3;i++) {	
			res[count][index] = i;
			print(index+1,sum+i);
		}
	}

}
