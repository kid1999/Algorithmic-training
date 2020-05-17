package LeetCode;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/17 8:46
 **/
public class P210 {
    public static void main(String[] args) {

    }

    // 方法 1 最简单的 BFS
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        if (numCourses == 0) return new int[0];
//        int[] inDegrees = new int[numCourses];
//        // 建立入度表
//        for (int[] p : prerequisites) {
//            inDegrees[p[0]]++;
//        }
//        // 入度为0的节点队列
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < inDegrees.length; i++) {
//            if (inDegrees[i] == 0) queue.offer(i);
//        }
//        int count = 0;  // 记录可以学完的课程数量
//        int[] res = new int[numCourses];  // 可以学完的课程
//        while (!queue.isEmpty()){
//            int curr = queue.poll();
//            res[count++] = curr;
//            for (int[] p : prerequisites) {
//                if (p[1] == curr){
//                    inDegrees[p[0]]--;
//                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);
//                }
//            }
//        }
//        if (count == numCourses) return res;
//        return new int[0];
//    }






    // 方法 2：邻接矩阵 + DFS
    // 用 HashSet 作为邻接矩阵，加速查找速度
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        // HashSet 作为邻接矩阵
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }
        int[] mark = new int[numCourses]; // 标记数组
        Stack<Integer> stack = new Stack<>(); // 结果栈
        for (int i = 0; i < numCourses; i++) {
            if(!isCycle(graph, mark, i, stack)) return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean isCycle(HashSet<Integer>[] graph, int[] mark, int i, Stack<Integer> stack) {
        if (mark[i] == -1) return true;
        if (mark[i] == 1) return false;

        mark[i] = 1;
        for (int neighbor : graph[i]) {
            if (!isCycle(graph, mark, neighbor, stack)) return false;
        }
        mark[i] = -1;
        stack.push(i);
        return true;
    }


}
