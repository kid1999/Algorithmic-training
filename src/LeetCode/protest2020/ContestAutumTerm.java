package LeetCode.protest2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/25 15:00
 **/
public class ContestAutumTerm {

	public static void main(String[] args) {
//		for (int i = 0; i <=6 ; i++) {
//			for (int j = 0; j <=i*i ; j++) {
//				System.out.println(i + " " + j  + "  --> " + paintingPlan(i,j));
//			}
//		}
		System.out.println(paintingPlan(6,35));
//		int[] arr = {5,4,3,2,1};
//		int[] arr2 = {2,4,3,1,5};
//		System.out.println(isMagic(arr));
	}

	// 1
	public static int paintingPlan(int n, int k) {
		if( k < n) return 0;
		if(k == n*n) return 1;
		int res = 0;
		for (int i = 0; i <=n ; i++) {
			for (int j = 0; j <=n ; j++) {
				int sum = (n*i) + (j*(n-i));
				if(sum == k){
					res += Combination(n,i) * Combination(n,j);
				}
			}
		}
		return res;
	}
	//递归法
	private static int Combination(int n, int k) {
		if(k>n) return 0;
		else if(k==0||k==n) return 1;
		else return Combination(n-1, k)+Combination(n-1, k-1);
	}



	 // 2
	 public static boolean isMagic(int[] target) {
		 int n = target.length;
		 int[] source = new int[n];
		 for (int i = 0; i <n ; i++) {
			 source[i] = i+1;
		 }
		 int[] nums = new int[n];
		 for (int k = 1; k <=n ; k++) {
		 	 int index = 0;
		 	 int c = 0;
		 	 boolean f = false;
		 	 while (index < n){
		 	 	if(index == 0) nums = getArr(source,index);
		 	 	else nums = getArr(nums,index);
			     for (int j = 0; j <k ; j++) {
			     	if(index >= n-1) return true;
			     	if(nums[index - c*k] != target[index]) {
			     		f = true;
			     		break;
			        }
			     	index++;
			     }
			     c++;
			     if (f) break;
		     }
		 	 if (!f) return true;
		 }
		 return false;
	 }
	 public static int[] getArr(int[]arr,int l){
		int n = arr.length;
		int[] res = new int[n];
		int count = 0;
		 for (int i = 0; i <n-l ; i++) {
			 if(i % 2 == 1) res[count++] = arr[i+l];
		 }
		 for (int i = 0; i <n-l ; i++) {
			 if(i % 2 == 0) res[count++] = arr[i+l];
		 }
		 return res;
	 }


	 // 4

}
