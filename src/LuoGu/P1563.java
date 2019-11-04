package LuoGu;

import java.util.Scanner;

public class P1563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n+1];
		String[] names = new String[n+1];
		for (int i = 0; i <n ; i++) {
			arr[i] = sc.nextInt();
			names[i] = sc.next();
		}
		int cur = 0;
		int flag = arr[0];
		for (int i = 0; i <m ; i++) {
			int to = sc.nextInt();
			int length = sc.nextInt();
			// in
			if(flag == 0){
				// left
				if(to == 0) cur = (cur - length + n)%n;
				else cur = (cur + length + n)%n;
			}else{
				if(to == 0) cur = (cur + length + n)%n;
				else cur = (cur - length + n)%n;
			}
//			System.out.println(names[cur]);
			flag = arr[cur];
		}
		System.out.println(names[cur]);
	}
}
