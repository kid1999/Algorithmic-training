/**
@author: kid1999
@date: 2021/8/6 9:52
@desc: P91
**/

package main

func numDecodings(s string) int {
	n := len(s)
	dp := make([]int,n + 1)
	dp[0] = 1
	for i := 0;i<n;i++ {
		if s[i] == '0'{
			dp[i+1] = 0
		}else{
			dp[i+1] = dp[i]
		}
		if i > 0 && (s[i-1] == '1' || (s[i-1] == '2' && s[i] <= '6')) {
			dp[i+1] += dp[i-1]
		}
	}
	return dp[n]
}

func main() {
	s := numDecodings("226")
	println(s)
}