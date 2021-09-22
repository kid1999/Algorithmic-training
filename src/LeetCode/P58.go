/**
@author: kid1999
@date: 2021/9/21 11:15
@desc: P58
**/

package main

import (
	"strings"
)

func main() {
	lengthOfLastWord("   fly me   to   the moon  ")
}


func lengthOfLastWord(s string) int {
	s = strings.Trim(s," ")
	split := strings.Split(s, " ")
	return len(split[len(split)-1])
}