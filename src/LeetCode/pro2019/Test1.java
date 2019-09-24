package LeetCode.pro2019;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int[] arr = new int[s];
		for (int i = 0; i <s ; i++) {
			arr[i] = sc.nextInt();
		}
		int[] res = fraction(arr);
		for (int n:res) {
			System.out.print(n +" ");
		}
	}
	public int game(int[] guess, int[] answer) {
		int res = 0;
		for (int i = 0; i <guess.length ; i++) {
			if(answer[i] == guess[i]) res++;
		}
		return res;
	}

	public static int[] fraction(int[] cont) {
		int[] res = new int[2];
		int a = 1,b = cont[cont.length-1],t;
		for (int i = cont.length-2; i >=0 ; i--) {
			int tmp = b;
			b = cont[i]*tmp+a;
			if((tmp == 0 || a == 0) && cont[i] != 0){
				b = cont[i];
				a = 1;
			}else if((tmp == 0 || a == 0) && cont[i] == 0){
				a = b = 0;
			}else a = tmp;
		}
		if(a<0 && b<0){
			a = -a;
			b = -b;
		}
		res[0] = a;
		res[1] = b;
		if (a ==0 || b == 0) return res;
		// 辗转相除法
		if(a < b) {
			t = a;
			a = b;
			b = t;
		}
		while(b != 0) {
			t = a % b;
			a = b;
			b = t;
		}
		res[0] = res[0]/a;
		res[1] = res[1]/a;
		return res;
	}


}
