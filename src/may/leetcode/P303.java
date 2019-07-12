package may.leetcode;


import java.util.*;

class Node{
  int t;
  int v;
}
public class P303 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Integer[]> list = new ArrayList<>();
    for (int i = 0; i <n ; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      Node[] dat = new Node[a];
      for (int j = 0; j <a ; j++) {
        dat[j] = new Node();
        dat[j].t = sc.nextInt();
      }
      for (int j = 0; j <a ; j++) {
        dat[j].v = sc.nextInt();
      }

      // start
//      A
      Arrays.sort(dat, new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
          return o1.t - o2.t;
        }
      });

      int sum1 = 0;
      int sum0 = 0;
      int k = 0;
      while (sum1 + dat[k].t<=b && k<a){
        sum1+= dat[k].t;
        sum0+= dat[k++].v;
      }

      Arrays.sort(dat, new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
          return o2.v - o1.v;
        }
      });

      int sum2 = 0;
      int sum3 = 0;
      int j = 0;
      while (sum2 + dat[j].t<=b && j<a){
        sum2+= dat[j].t;
        sum3+= dat[j++].v;
      }
      if(sum0>sum3) System.out.println("A");
      else if(sum0<sum3) System.out.println("B");
      else System.out.println("SAME");
    }
  }

}
