/**
@author: kid1999
@date: 2021/9/15 17:04
@desc: P1122
**/

package main

func main() {
	arr1 := []int{2,3,1,3,2,4,6,7,9,2,19}
	arr2 := []int{2,1,4,3,9,6}

	relativeSortArray(arr1,arr2)
}

// bad function
//func relativeSortArray(arr1 []int, arr2 []int) []int {
//	tmp := []int{}
//	vis := make([]bool, len(arr1))
//	sort.Ints(arr1)
//	for _,n := range arr2 {
//		for j := 0; j < len(arr1); j++ {
//			if n == arr1[j]{
//				tmp = append(tmp, arr1[j])
//				vis[j] = true
//			}
//		}
//	}
//	for i := 0; i < len(arr1); i++ {
//		if !vis[i]{
//			tmp = append(tmp, arr1[i])
//		}
//	}
//	return tmp
//}




func relativeSortArray(arr1 []int, arr2 []int) []int {
	dp := make([]int, 1001)
	res := []int{}
	for _,i := range arr1{
		dp[i]++
	}
	for _,n := range arr2{
		for dp[n] > 0{
			res = append(res,n)
			dp[n]--
		}
	}
	for i := 0; i <=1000;i++{
		for dp[i] > 0{
			res = append(res,i)
			dp[i]--
		}
	}
	return res
}
