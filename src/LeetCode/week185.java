package LeetCode;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/19 10:28
 **/
public class week185 {
    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcroa"));
    }


    // 1
    public  String reformat(String s) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (char c:s.toCharArray()) {
            if(c>=64){
                s1.push(c);
            }else{
                s2.push(c);
            }
        }
        String res = "";
        if(Math.abs(s1.size()-s2.size())>1) return  "";
        if(s1.size()>=s2.size()){
            while (!s1.isEmpty() || !s2.isEmpty()){
                if(!s1.isEmpty()) res += String.valueOf(s1.pop());
                if(!s2.isEmpty()) res += String.valueOf(s2.pop());
            }
        }
        else {
            while (!s1.isEmpty() || !s2.isEmpty()){
                if(!s2.isEmpty()) res += String.valueOf(s2.pop());
                if(!s1.isEmpty()) res += String.valueOf(s1.pop());
            }
        }
        return res;
    }
    // 2
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<Integer,Map<String,Integer>> tables = new TreeMap<>();
        TreeSet<String> foods = new TreeSet<>();
        for (List<String> od:orders) {
            String name = od.get(2);
            foods.add(name);

            int id = Integer.parseInt(od.get(1));

            if(!tables.containsKey(id)){
                Map<String,Integer> map = new HashMap<>();
                tables.put(id,map);
            }
            Map<String,Integer> cur = tables.get(id);
            int count = cur.getOrDefault(name,0)+1;
            cur.put(name,count);
        }
        List<String> head = new ArrayList<>();
        head.add("Table");
        for (String s:foods) {
            head.add(s);
        }
        res.add(head);

        for (int id:tables.keySet()) {
            Map<String,Integer> map = tables.get(id);
            List<String> line = new ArrayList<>();
            line.add(""+id);

            for (int i = 1; i <head.size() ; i++) {
                String name = head.get(i);
                int count = map.getOrDefault(name,0);
                line.add(""+count);
            }
            res.add(line);
        }
        return res;
    }



    // 3

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0,r=0,o=0,a=0,k=0;
        int[] arr = new int[croakOfFrogs.length()];
        int max = 0;
        for (char ch:croakOfFrogs.toCharArray()) {
            if(ch == 'c') c++;
            else if(ch == 'r') r++;
            else if(ch == 'o') o++;
            else if(ch == 'a') a++;
            else k++;
            if(!judge(c,r,o,a,k)) return -1;
            if(c > max) max = c;
            if(c>0){
                a=a-k;r=r-k;o=o-k;c=c-k;k=0;
            }
        }
        if(reduce(c,r,o,a,k)) return max;
        else return -1;
    }
    public static boolean judge(int c,int r,int o,int a,int k){
        if(c>=r && r>=o && o>=a && a>=k) return true;
        else return false;
    }
    public static boolean reduce(int c,int r,int o,int a,int k){
        if(c==a&&a==r&&r==o&&o==k) return true;
        else return false;
    }


    // 4

}
