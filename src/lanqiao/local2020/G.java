package lanqiao.local2020;

import java.util.Scanner;

public class G {

	static int res = 0;
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nums = new int[n+1];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		merge_sort(nums,0,n-1);
		System.out.println(res);
	}

	public static void merge_sort(int[] nums,int l,int r){
		if(l>=r) return;
		int mid = l+r>>1;
		merge_sort(nums,l,mid);
		merge_sort(nums,mid+1,r);
		int[] tmp = new int[r-l+1];
		int k=0,left=l,right=mid+1;
		while(left<=mid && right<=r){
			if(nums[left]<=nums[right]) tmp[k++] = nums[left++];
			else {
				tmp[k++] = nums[right++];
				res+=mid-left+1;            // 核心: 逆序对 应该是后面的数去前面的路程之和
			}
		}
		while(left<=mid){
			tmp[k++] = nums[left++];
		}
		while(right<=r) tmp[k++] = nums[right++];
		for(int n:tmp) nums[l++] = n;
	}

}
