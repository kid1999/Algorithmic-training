/**
@auther: kid1999
@date: 2021/8/4 10:41
@desc: P343
**/

package main

func integerBreak(n int) int {
	if n <= 3{
		return n-1
	}
	dp := make([]int, n+1)
	dp[1],dp[2],dp[3] = 1,2,3
	for i := 3; i <= n; i++ {
		for j := 1; j <i ; j++ {
			t1 := dp[i-j] * dp[j]
			if t1 > dp[i]{
				dp[i] = t1
			}
		}
	}
	return dp[n]
}

func main() {
	println(integerBreak(9))
}
