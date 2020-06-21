package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/21 10:21
 **/
public class week194 {
    public static void main(String[] args) {
        int[] rains = {1,2,0,0,2,1};
        int[] p = avoidFlood(rains);
        for (int n:p) {
            System.out.println(n);
        }
    }

    // 1
    public int xorOperation(int n, int start) {
        int[] dp = new int[n];
        for (int i = 0; i <n ; i++) {
            dp[i] = start + 2*i;
        }
        int res = 1;
        for (int k:dp) {
            res ^= k;
        }
        return res;
    }

    // 2
    public String[] getFolderNames(String[] names) {
        HashMap<String,Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i <names.length ; i++) {
            String name = names[i];
            if(!map.containsKey(name)) map.put(name,0);
            else map.put(name, map.get(name) + 1);
            int count = map.get(name);
            if(count == 0) res[i] = name;
            else {
                String newName = name + "(" + count +  ")";
                if(!map.containsKey(newName)) {
                    map.put(newName,0);
                    res[i] = newName;
                }else{
                    while (map.containsKey(newName)){
                        count++;
                        newName = name + "(" + count +  ")";
                    }
                    map.put(newName,0);
                    res[i] = newName;
                }
            }
        }
        return res;
    }


    // 3
    public static int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] res = new int[len];
        int length = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> before = new HashMap<>();
        for (int i = 0; i <len ; i++) {
            before.put(rains[i],before.getOrDefault(rains[i],0)+1);
            if(rains[i] > 0) res[i] = -1;
            else{
                int end = i;
                while (rains[end] == 0) end++;  //跳出空白期
                int length2 = end-i;
                length += length2;
                HashMap<Integer,Integer> next = new HashMap<>();
                while (end<len && rains[end] != 0){     // 下一次雨季
                    next.put(rains[end],next.getOrDefault(rains[end],0)+1);
                    end++;
                }
                //
                for (Map.Entry<Integer,Integer> e:before.entrySet()) {
                    int id = e.getKey();
                    int bcount = e.getValue();
                    int ncount = next.getOrDefault(id,0);
                    if(bcount-(length-length2) >1 || bcount < ncount || length < ncount) return new int[0];
                    for (int j = 0; j <ncount ; j++) {
                        res[i++] = id;
                        length--;
                    }
                    before.put(id,length);
                }
                boolean f = true;
                for (Map.Entry<Integer,Integer> e:before.entrySet()) {
                    int id = e.getKey();
                    int count = e.getValue();
                    if(id != 0 && count>0) {
                        f = false;
                        break;
                    }
                }
                while (length > 0 && f){
                    res[i++] = 1;
                    length--;
                }
            }
        }
        return res;
    }



    // 4
}
