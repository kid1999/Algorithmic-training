package LeetCode;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/17 10:24
 **/
public class week189 {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println();
    }


    // 1
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i <startTime.length ; i++) {
            if(queryTime>=startTime[i] && queryTime<=endTime[i]) res++;
        }
        return res;
    }


    // 2
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String res = "";
        for (String s:words) {
            res += " " + s.toLowerCase();
        }
        res = String.valueOf(res.charAt(1)).toUpperCase() + res.substring(2);
        return res;
    }

    // 3
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        int len = favoriteCompanies.size();
        Set<String>[] sets = new HashSet [len+1];
        for (int i = 0; i <len ; i++) {
            sets[i] = new HashSet<>();
            for (String s:favoriteCompanies.get(i)) {
                sets[i].add(s);
            }
        }
        for (int i = 0; i <len ; i++) {
            System.out.println(sets[i].size());
        }
        for (int i = 0; i <len ; i++) {
            List<String> list1 = favoriteCompanies.get(i);
            for (int j = 0; j <len ; j++) {
                if(j == i) continue;
                boolean f = true;
                if(sets[j].size() >= list1.size()){
                    for (String s:list1) {
                        if(!sets[j].contains(s)){
                            f = false;
                            break;
                        }
                    }
                }else f = false;
                if(f){
                    res.add(i);
                    break;
                }
            }
        }

        List<Integer> reslut = new ArrayList<>();
        for (int i = 0; i <len ; i++) {
            if(!res.contains(i)) reslut.add(i);
        }
        return reslut;
    }



    // 4
}
