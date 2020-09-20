package nowcoder.bytedance;

import java.util.Scanner;

/**
 * @author kid1999
 * @date 2020/9/20 19:37
 * @title A
 */

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		for (int dep = 1; dep < n/2; dep++) {
			String window = "";
			for (int i = 0; i <n-dep ; i++) {
				String ss = s.substring(i,dep+i);
				if(window.equals(ss)){
					System.out.println(window);
					return;
				}else {
					window = ss;
				}
			}
		}
		System.out.println(s);
	}
}
