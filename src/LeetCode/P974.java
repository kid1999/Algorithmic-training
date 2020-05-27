package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kid1999
 * @title: P974
 * @date 2020/5/27 10:07
 */

public class P974 {
	public static void main(String[] args) {

	}

	// 前缀和+同余定理 p[j]- p[i] % K = 0 等价于 p[j] % k == p[i] % K
//	public int subarraysDivByK(int[] A, int K) {
//		int sum = 0, res = 0;
//		Map<Integer, Integer> map = new HashMap<>();
//		map.put(0, 1);
//		for (int n : A) {
//			sum += n;
//			int curMod = (sum%K+K)%K;
//			int preCount = map.getOrDefault(curMod, 0);
//			res += preCount;
//			map.put(curMod, preCount + 1);
//		}
//		return res;
//	}

	public int subarraysDivByK(int[] A, int k) {
		int[] dp = new int[k];
		dp[0] = 1;
		int res=0,sum=0;
		for(int n:A){
			sum = ((sum+n)%k+k)%k;
			res += dp[sum];
			dp[sum]++;
		}
		return res;
	}
}
