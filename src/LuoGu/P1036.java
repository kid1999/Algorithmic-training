package LuoGu;

import java.util.Scanner;

public class P1036 {
	static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(selectAndSum(k,0,0,n-1));
    }

    public static int selectAndSum(int k,int sum,int l,int r){
        if (k==0) return isprime(sum) ? 1 : 0;
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += selectAndSum(k-1,sum+nums[i],l+1,r);
        }
        return res;
    }
    
    public static boolean isprime(int num) {
    	int s = (int) Math.sqrt(num);
    	for(int i=2;i<=s;i++) {
    		if(num%i==0) return false;
    	}
    	return true;
    }
}
