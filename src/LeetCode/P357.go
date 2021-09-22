/**
@author: kid1999
@date: 2021/8/6 10:34
@desc: P357
**/

package main


func countNumbersWithUniqueDigits(n int) int {
	if n == 0 { return 0}
	if n == 1 { return 10}
	dp := make([]int,n+1)
	dp[0] = 1
	dp[1] = 10
	dp[2] = 81

	for i := 2; i<=n;i++ {
		dp[i] = (dp[i-1] - dp[i-2]) * (10-i+1) + dp[i-1]
	}
	return dp[n]
}

func main() {
	println(countNumbersWithUniqueDigits(2))
}
/*

f[1] = 10
f[2] = 91
f[3] =
 */