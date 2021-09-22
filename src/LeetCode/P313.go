/**
@auther: kid1999
@date: 2021/8/5 9:37
@desc: P313
**/

package main

import "math"

func nthSuperUglyNumber(n int, primes []int) int {
	ids := make([]int,len(primes))
	dp := make([]int,n)
	dp[0] = 1

	for i :=1; i<n; i++ {
		min := math.MaxInt32
		for j :=0; j<len(primes); j++ {
			if dp[ids[j]] * primes[j] < min {
				min = dp[ids[j]] * primes[j]
			}
		}
		dp[i] = min
		for j :=0; j<len(primes); j++ {
			if min == dp[ids[j]] * primes[j]{
				ids[j]++
			}
		}
	}
	return dp[n-1]
}
