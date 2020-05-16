package LeetCode;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/16 10:04
 **/
public class P127 {
    public static void main(String[] args) {
        System.out.println("abcd".substring(0,1) + 'A' + "abcd".substring(2));
    }

    // bfs
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if(beginWord.equals(endWord)) return 1;
    int res = 1;
    Queue<String> queue = new LinkedList<>();
    Set<String> set = new HashSet<>();
    for (String s:wordList) set.add(s);
    if(!set.contains(endWord)) return 0;
    queue.add(beginWord);
    while (!queue.isEmpty()){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String word = queue.poll();
            for (char j = 'a'; j <='z' ; j++) {
                for (int k = 0; k <word.length(); k++) {
                    String next = word.substring(0,k) + j + word.substring(k+1);
                    if(next.equals(endWord)) return res+1;
                    if(set.contains(next)){
                        set.remove(next);
                        queue.add(next);
                    }
                }
            }
        }
        res++;
    }
    return 0;
}
}
