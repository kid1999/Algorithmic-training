package CCPC;

import java.util.*;

public class Test1006 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[n];
		int[] tmp = new int[m];
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i <n ; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i=0; i <m ; i++) {
			int num = sc.nextInt();
			tmp[i] = num;
			nums[num-1] = 0;
			if(map.containsKey(num)){
				tmp[map.get(num)] = 0;
				map.put(num,i);
			}else{
				map.put(num,i);
			}
		}
		for (int j = m-1; j >=0 ; j--) {
			if(tmp[j] != 0) System.out.print(tmp[j] + " ");
		}
		for (int j = 0; j < n; j++) {
			if(nums[j] !=0) System.out.print(nums[j] + " ");
		}
	}
}
