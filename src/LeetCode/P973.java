package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author kid1999
 * @create 2020-11-09 19:23
 * @description TODO
 **/
public class P973 {
    public static void main(String[] args) {
        int[][] arr = {
                {3,3},{5,-1},{-2,4}
        };
        System.out.println(Arrays.deepToString(kClosest(arr,2)));
    }


    static class node{
        int dist;
        int i;

        public node(int dist, int i) {
            this.dist = dist;
            this.i = i;
        }

        public node() {
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<node> queue = new PriorityQueue<>(K, (o1,o2)->{return (o2.dist-o1.dist);});
        for (int i = 0; i <points.length ; i++) {
            int dis = compute(points[i]);
            System.out.println(dis);
            if(queue.size()<K) queue.add(new node(dis,i));
            else {
                if(queue.peek().dist > dis) {
                    queue.poll();
                    queue.add(new node(dis,i));
                }
            }
        }
        int[][] res = new int[queue.size()][2];
        for (int i = 0; i <K ; i++) {
            node n = queue.poll();
            res[i] = points[n.i];
        }
        return res;
    }

    public static int compute(int[] arr){
        return Math.abs(arr[0]*arr[0] + arr[1]*arr[1]);
    }

}