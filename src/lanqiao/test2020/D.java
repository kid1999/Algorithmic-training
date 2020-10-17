package lanqiao.test2020;

public class D {
	public static void main(String[] args) {
		/**
		 * 枚举：
		 * 1 个 发光： 7
		 * 2 个 发光： 10  | ab bc cd de ef fa | g*4
		 * 3 个 发光： 10  | abc bcd cde def efa fab  + g*4
		 * 4 个 发光： C(7,3) - 6   |  cef ceb ceg 或 fbe fbg fbc
		 * 5 个 发光： C(7,2) - 2   |  ec 或 fb
		 * 6 个 发光： 7
		 * 7 个 发光： 1
		 */
		long res = 0;
		res = 7+10+10+C(7,3)-6+C(7,2)-2+7+1;
		System.out.println(res);
	}

	private static long C(int n, int k) {
		if(k>n) return 0;
		else if(k==0||k==n) return 1;
		else return C(n-1, k)+C(n-1, k-1);
	}
	public static int A(int n,int m) {
		if(n<m) return 0;
		int res = 1;
		for(int i = n-m+1;i<=n;i++) {
			res *= i;
		}
		return res;
	}
}
