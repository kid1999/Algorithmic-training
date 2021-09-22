/**
@auther: kid1999
@date: 2021/8/2 12:49
@desc: P743
**/

package main

import "math"


func networkDelayTime(times [][]int, n int, k int) int {
	dp := make([][]int, n+1)
	for i := range dp{
		dp[i] = make([]int, n+1)
		for j := range dp{
			dp[i][j] = math.MaxInt32
		}
	}
	for _,arr:= range times{
		dp[arr[0]][arr[1]] = arr[2]
	}
	res := dijkstra(dp,k)
	max := math.MinInt32
	for i := 1; i <len(dp); i++ {
		if res[i] == math.MaxInt32{
			return -1
		}
		if res[i] > max{
			max = res[i]
		}
	}
	return max
}


func dijkstra(dp [][]int,start int) []int{
	vis := make([]bool, len(dp))
	res := make([]int,len(dp))
	for i := 0; i < len(dp); i++{
		res[i] = dp[start][i]
	}
	res[start] = 0

	for i:= 1; i< len(dp);i++{
		min := math.MaxInt32
		p := 0

		for j := 1; j < len(dp);j++ {
			if j != start && !vis[j] && res[j] < min{
				min = res[j]
				p = j
			}
		}
		vis[p] = true

		for j:= 1; j < len(dp);j++{
			if j == p || dp[p][j] == math.MaxInt32{
				continue
			}
			if res[p] + dp[p][j] < res[j]{
				res[j] = res[p] + dp[p][j]
			}
		}
	}
	return res
}

