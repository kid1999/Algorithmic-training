package LeetCode;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/20 20:15
 **/
public class P621 {
    public static void main(String[] args) {
        char[] chars = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(chars,2));
    }

    // 基于排序的模拟算法
//    public static int leastInterval(char[] tasks, int n) {
//        int res = 0;
//        int[] chs = new int[26];
//        for (char c:tasks) {
//            chs[c-65]++;
//        }
//        Arrays.sort(chs);
//        while (chs[25] > 0){
//            int i = 0;
//            while (i<=n){       // 每个周期就把前面几个频率高的消掉，防止停顿
//                if(chs[25] == 0) break;
//                if(i<26 && chs[25-i] > 0) chs[25-i]--;
//                res++;
//                i++;
//            }
//            Arrays.sort(chs);  // 消去高峰后重新排序
//        }
//        return res;
//    }


    // 基于优先队列的模拟算法
//    public static int leastInterval(char[] tasks, int n) {
//        int res = 0;
//        int[] chs = new int[26];
//        for (char c:tasks) {
//            chs[c-65]++;
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
//        for (int i = 0; i <26 ; i++) {
//            if(chs[i] > 0) queue.add(chs[i]);
//        }
//
//        while (!queue.isEmpty()){
//            List<Integer> temp = new ArrayList<>();
//            int i = 0;
//            while (i<=n){
//                if(!queue.isEmpty() && queue.peek() > 1) temp.add(queue.poll()-1);
//                else queue.poll();
//                res++;
//                i++;
//                if(queue.isEmpty() && temp.isEmpty()) break;
//            }
//            for (int num:temp) {
//                queue.add(num);
//            }
//        }
//        return res;
//    }


    /**
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     *      如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     *      则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        //步骤1
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        //步骤2
        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        //步骤3
        while (i >= 0 && counts[i] == maxCount) {
            retCount++;
            i--;
        }
        //步骤4
        return Math.max(retCount, tasks.length);
    }
}
