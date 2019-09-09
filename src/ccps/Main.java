package ccps;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i <t ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int j=0;j<=a && j<=b;j++){
				if(((j^a) & (j^b)) == 0){
					if(j==0) System.out.println(1);
					else System.out.println(j);
					break;
				}
			}
		}
	}
}
