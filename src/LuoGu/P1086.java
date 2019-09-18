import java.util.Arrays;
import java.util.Scanner;

public class P1086 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int k = sc.nextInt();
    Node[] nodes = new Node[m*n];
    for (int i = 0; i < m ; i++) {
      for (int j = 0; j < n ; j++) {
        nodes[i*n+j] = new Node(i,j,sc.nextInt());
      }
    }
    Arrays.sort(nodes);
    int res = 0;
    Node tmp = new Node(0,nodes[0].x,0);
    k -= 2;
    for (Node node:nodes) {
      int distance = Math.abs(node.x-tmp.x) + Math.abs(node.y-tmp.y) + node.y + 1;   //明式距离 + 拔
      if(distance <= k){
        k -= (Math.abs(node.x-tmp.x) + Math.abs(node.y-tmp.y) + 1);
        res += node.num;
        tmp = node;
      }else {
        break;
      }
    }
    System.out.println(res);
  }
}

class Node implements Comparable<Node>{
  int x;
  int y;
  int num;
  public Node(int y, int x,int num) {
    this.x = x;
    this.y = y;
    this.num = num;
  }
  @Override
  public int compareTo(Node other) {
    return other.num - this.num;
  }
}
