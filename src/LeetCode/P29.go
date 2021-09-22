/**
@author: kid1999
@date: 2021/8/7 10:59
@desc: P29
**/

package main

import "math"

func divide(dividend int, divisor int) int {
	if dividend==0 {return 0}
	if dividend==math.MinInt32 && divisor==-1 {return math.MaxInt32}

	diffSign:=false
	if (dividend<0)!=(divisor<0) {
		diffSign=true
	}

	i,j,sum := 0,0,0
	for {
		tmp:=0
		if diffSign {
			tmp=sum-divisor<<j
		}else{
			tmp=sum+divisor<<j
		}
		if (dividend>0 && tmp>dividend) || (dividend<0 && tmp<dividend) {
			if j==0 {break}
			j-- //步长减半
			continue
		}
		sum=tmp
		i+=1<<j
		j++ //步长加倍
	}

	if diffSign {
		return -i
	}
	return i
}

func main() {
	println(divide(7,-3))
}
