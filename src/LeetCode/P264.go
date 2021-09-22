/**
@auther: kid1999
@date: 2021/8/5 8:33
@desc: P264
**/

package main

//func nthUglyNumber(n int) int {
//	dp := make([]int,n)
//	for i := 0; i <n; i++ {
//		dp[i] = math.MaxInt32
//	}
//	dp[0] = 1
//	for i :=1; i <n; i++ {
//		for j :=0; j < i; j++ {
//			if dp[i-1] < 2*dp[j] && dp[i] > 2*dp[j]{
//				dp[i] = 2*dp[j]
//				break
//			}
//			if dp[i-1] < 3*dp[j] && dp[i] > 3*dp[j]{
//				dp[i] = 3*dp[j]
//			}
//			if dp[i-1] < 5*dp[j] && dp[i] >5*dp[j]{
//				dp[i] = 5*dp[j]
//			}
//		}
//	}
//	return dp[n-1]
//}


func nthUglyNumber(n int) int {
	dp := make([]int,n)
	dp[0] = 1
	i2,i3,i5 := 0,0,0
	for i :=1; i <n; i++ {
		if 2*dp[i2] < 3*dp[i3]{
			dp[i] = 2*dp[i2]
		}else{
			dp[i] = 3*dp[i3]
		}
		if 5*dp[i5] < dp[i]{
			dp[i] = 5*dp[i5]
		}

		if dp[i] == 2*dp[i2]{
			i2++
		}
		if dp[i] == 3*dp[i3]{
			i3++
		}
		if dp[i] == 5*dp[i5]{
			i5++
		}
	}
	return dp[n-1]
}


func main() {
	nthUglyNumber(10)
}
