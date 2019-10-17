package CF.R589.world5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean f = false;
		for (int i = 0; i <n ; i++) {
			int num = sc.nextInt();
			if(num%2==0){
				System.out.println(num/2);
			}
			else {
				if(num<0){
					if(f) System.out.println(num/2);
					else System.out.println(num/2-1);
				}
				else{
					if(f) System.out.println(num/2+1);
					else System.out.println(num/2);
				}
				f = !f;
			}
		}
	}
}
