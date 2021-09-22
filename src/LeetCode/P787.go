/**
@auther: kid1999
@date: 2021/8/2 16:54
@desc: P787
**/

package main

import "math"

func findCheapestPrice(n int, flights [][]int, src int, dst int, k int) int {
	dp := make([][]int,n)
	m := make(map[int]int)
	for i := 0; i < n; i++ {
		dp[i] = make([]int,n)
	}
	for _, d:= range flights{
		dp[d[0]][d[1]] = d[2]
	}
	res := dfs(m,dp,src,dst,k+1,0)
	if res == math.MaxInt32{
		return -1
	}
	return res
}

func dfs(m map[int]int,dp [][]int, src int,dst int, k int,res int) int {
	if k >=0 && src == dst  {
		return res
	}else if k <= 0{
		return math.MaxInt32
	}

	if n,ok := m[src];ok{
		return n
	}

	min := math.MaxInt32
	for i := 0; i < len(dp); i++ {
		if dp[src][i] != 0{
			t := dfs(m,dp,i,dst,k-1,res + dp[src][i])
			if t < min{
				min = t
			}
		}
	}
	m[src] = min
	return min
}



//func findCheapestPrice(n int, flights [][]int, src int, dst int, k int) int {
//	dp := make([]int,n)
//	for i := range dp{
//		dp[i] = math.MaxInt32
//	}
//	dp[src] = 0
//	for i := 0; i < k+1; i++ {
//		t := make([]int,n)
//		copy(t, dp)
//		for _,arr := range flights {
//			if dp[arr[1]] > t[arr[0]] + arr[2]{
//				dp[arr[1]] = t[arr[0]] + arr[2]
//			}
//		}
//	}
//	if dp[dst] != math.MaxInt32{
//		return dp[dst]
//	}else{
//		return -1
//	}
//}
