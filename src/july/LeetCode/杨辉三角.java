

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}


	/**
	 * 递推关系 : f(x,y) = f(x-1,y-1) + f(x,y-1)
	 * 基本情况 : x=0 he x=size() = 1
	 */

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> nums = new ArrayList<>();
		for (int i = 0; i <numRows ; i++) {
			List<Integer> one = new ArrayList<>();
			for (int j = 0; j <= i ; j++) {
				if(j==0 || j==i){
					one.add(1);
				}else{
					one.add(nums.get(i-1).get(j)+ nums.get(i-1).get(j-1));
				}
			}
			nums.add(one);
		}
		return nums;
	}
}
