package lanqiao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E {
  private static class Node{
    int x;
    int y;
    String res;
    Node(int x,int y,String res){
      this.x = x;
      this.y = y;
      this.res = res;
    }
  }
  private static char[][] nums;
  private static int[] func;
  private static boolean[][] vised;
  public static void main(String[] args) {
    int height = 30;
    int width = 50;
    Scanner sc = new Scanner(System.in);
    nums = new char[height][width];
    for (int i = 0; i <height; i++) {
      nums[i] = sc.next().toCharArray();
    }
    func = new int[] {1,0,0,-1,0,1,-1,0};
    Queue<Node> q = new LinkedList<>();
    vised = new boolean[height][width];
    Node start = new Node(0,0,"");
    q.add(start);
    vised[0][0] = true;
    while(!q.isEmpty()) {
      Node node = q.poll();
      if(nums[node.x][node.y] == '1') continue;
      if(node.x == height-1 && node.y == width-1) {
        System.out.println(node.res);
        return;
      }
      else {
        for(int k=0;k<8;k+=2) {
          String tmp = "";
          if(k == 0) tmp = "D";
          if(k == 2) tmp = "L";
          if(k == 4) tmp = "R";
          if(k == 6) tmp = "U";
          int x = node.x+func[k];
          int y = node.y+func[k+1];
          if(x <0 || y<0 || x>=nums.length || y>=nums[0].length) continue;
          Node new_node = new Node(x,y,node.res + tmp);
          if(!vised[x][y]) q.offer(new_node);
          vised[x][y] = true;
        }
      }
    }
  }
}
