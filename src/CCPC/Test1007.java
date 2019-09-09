package CCPC;

import java.util.Scanner;

public class Test1007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i <t ; i++) {
			int n = sc.nextInt();
			char[][] arr = {{'C','C'},{'P','C'}};
			while (arr.length < Math.pow(2, n)){
				char[][] res = new char[arr.length*2][arr.length*2];
				int a=0;
				for(int j=0;j<arr.length;j++){
					int b = 0;
					for (int k=0; k <arr.length;k++) {
						if(arr[j][k] == 'C'){
							res[a][b] = 'C';
							res[a][b+1] = 'C';
							res[a+1][b] = 'P';
							res[a+1][b+1] = 'C';
						}else{
							res[a][b] = 'P';
							res[a][b+1] = 'P';
							res[a+1][b] = 'C';
							res[a+1][b+1] = 'P';
						}
						b+=2;
					}
					a+=2;
				}
				arr = res;
			}
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length-1; k++) {
					System.out.print(arr[j][k]);
				}
				System.out.println(arr[j][arr.length-1]);
			}
		}
	}
}

