package LeetCode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2019/12/14 22:29
 **/
public class week15 {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,3};
//        System.out.println(findSpecialInteger(arr));
        int[][] arr = {{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(arr));
    }

    // 1
    public static int findSpecialInteger(int[] arr) {
        int num = arr[0],count = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(num == arr[i]) count++;
            else count = 1;
            num = arr[i];
            if(count*4 > arr.length)break;
        }
        return num;
    }


    // 2
    public static int removeCoveredIntervals(int[][] intervals) {
        List<Pair<Integer,Integer>> list = new LinkedList<>();
        for (int i = 0; i <intervals.length ; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            boolean f = false;
            for (int j = 0; j <list.size() ; j++) {
                int c = list.get(j).getKey();
                int d = list.get(j).getValue();
                if(c <= a && b <= d){
                    f = true;
                    break;
                }
                else if(a <= c && d <= b){
                    list.remove(j);
                    j--;
                }
            }
            if(!f){
                list.add(new Pair<>(intervals[i][0],intervals[i][1]));
            }
        }
        return list.size();
    }

    // 3
    class CombinationIterator {
        int index;
        List<String> res;
        String strings;

        public CombinationIterator(String characters, int combinationLength) {
            index = 0;
            res = new ArrayList<>();
            strings = characters;
            dfs("",combinationLength,0);
            System.out.println(res);
        }
        public void dfs(String result,int len,int left){
            if(len == 0){
                res.add(result);
                return;
            }
            for (int i = left; i <strings.length() ; i++) {
                if(strings.length() - i < len) break;
                dfs(result + strings.charAt(i),len-1,i+1);
            }
        }

        public String next() {
            return res.get(index++);
        }

        public boolean hasNext() {
            return index < res.size();
        }
    }


    // 4



}
