package lanqiao.test2020;

public class C {
	public static void main(String[] args) {
		/**
		 * (1 1)  1
		 * (2 2)  5 = 1+2+2
		 * (3 3)  13 = 1+2+3+4+3
		 * (4 4)  25 = 1+2+3+4+5+6+4
		 * ...
		 * (20,20) = E[2*(n-1)] + 20
		 */

		int res = 20;
		for (int i = 1; i <=38 ; i++) {
			res+=i;
		}
		System.out.println(res);
	}
}
