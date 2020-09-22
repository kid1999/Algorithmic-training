package HDOJ.ccpc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kid1999
 * @date 2020/9/20 13:12
 * @desc
 **/
public class P1003 {
    public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i <t ; i++) {
			String s = bf.readLine();
			String[] ss = s.split(" ");
			int n = Integer.parseInt(ss[0]);
			int m = Integer.parseInt(ss[1]);
			int k = Integer.parseInt(ss[2]);
			long sum = 2 * (k-1);
			int min = Integer.MAX_VALUE;
			String nums = bf.readLine();
			for(String nn : nums.split(" ")){
				int num = Integer.parseInt(nn);
				min = Math.min(min,num);
				sum += Math.abs(num - k) * 2;
			}
			if(min < k) sum -= Math.abs(k-min) * 2;
			System.out.println(sum);
		}
	}
}
