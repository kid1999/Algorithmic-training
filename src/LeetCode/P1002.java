package LeetCode;

import java.util.*;

/**
 * @author kid1999
 * @create 2020-10-14 16:53
 * @description TODO
 **/
public class P1002 {
    public static void main(String[] args) {

    }

    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] res = new int[26];
        for (char c : A[0].toCharArray()) {
            res[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], temp[j]);
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i]; j++) {
                list.add(((char) ('a' + i) + ""));
            }
        }
        return list;
    }


}