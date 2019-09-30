package CF.R589;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.next();
		String r = sc.next();
		int min = Integer.parseInt(l);
		int max = Integer.parseInt(r);
		for (int i = min; i <=max ; i++) {
			boolean f = true;
			int[] nums = new int[128];
			StringBuffer res = new StringBuffer();
			for (char w:String.valueOf(i).toCharArray()) {
				if(nums[w] != 0){
					f = false;
					break;
				}
				else{
					nums[w]++;
					res.append(w);
				}
			}
			if(f){
				System.out.println(res);
				return;
			}
		}
		System.out.println(-1);
	}


}
