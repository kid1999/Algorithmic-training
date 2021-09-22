/**
@author: kid1999
@date: 2021/9/15 17:35
@desc: P912
**/

package main

func main() {

}

//
//func sortArray(nums []int) []int {
//	sort.Ints(nums)
//	return nums
//}



func sortArray(nums []int) []int {
	dp := make([]int, 50001)
	res := []int{}
	for _,n := range nums {
		dp[n]++
	}
	for i :=0; i <50001; i++ {
		for dp[i] > 0{
			res = append(res, i)
			dp[i]--
		}
	}
	return res
}