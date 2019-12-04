package LeetCode;

import java.util.*;

/**
 * @auther: kid1999
 * @date: 2019/12/4 9:15
 * @desc: P950
 **/
public class P950 {
    public static void main(String[] args) {

    }

//    public int[] deckRevealedIncreasing(int[] deck) {
//        int[] res = new int[deck.length];
//        Arrays.sort(deck);
//        int index = 0;
//        for (int i = 0; i < deck.length;i += 2) {
//            res[i] = deck[index];
//            index ++;
//        }
//
//        for (int i = 1; i < deck.length; i += 2) {
//            res[i] = deck[index];
//            index ++;
//        }
//        return res;
//    }


    public int[] deckRevealedIncreasing(int[] deck) {
        // 奇数筛 一轮一轮的筛
        int[] res = new int[deck.length];
        Set<Integer> set = new HashSet<>();
        Arrays.sort(deck);
        int count = 0;
        while (set.size()<deck.length){
            for (int i = 0; i <deck.length ; i++) {
                if(!set.contains(i)){
                    if((count&1)==0){
                        res[i] = deck[set.size()];
                        set.add(i);
                    }
                    count++;
                }
            }
            count = (count&1)==0 ? 0 : 1;
        }
        return res;
    }
}
