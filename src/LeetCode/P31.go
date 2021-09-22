/**
@author: kid1999
@date: 2021/8/7 10:11
@desc: P31
**/

package main

import (
	"math"
	"sort"
)

func nextPermutation(nums []int)  {
	n := len(nums)
	index := 0
	for i := n-1; i >= 0; i-- {
		// 在nums中倒序找到一个nums[i-1] < nums[i]的情况 表示可以进行交换，序列变大
		if i-1 >= 0 && nums[i-1] < nums[i]{
			// 在nums[i:]中找个大于nums[i-1]的最小的值，并交换
			minIdx,min := i,math.MaxInt32
			for j := i; j < n ; j++ {
				if nums[j] > nums[i-1] && nums[j] < min{
					min = nums[j]
					minIdx = j
				}
			}
			nums[i-1],nums[minIdx] = nums[minIdx],nums[i-1]
			index = i
			break
		}
	}
	sort.Ints(nums[index:])
}
