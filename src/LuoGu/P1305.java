package LuoGu;

import java.util.Scanner;

public class P1305 {
  private static class Node{
    int left;
    int right;
    int father;
  }
  static Node[] nodes;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    nodes = new Node[128];
    for (int i = 0; i <n ; i++) {
      char[] chars = sc.next().toCharArray();   // 0 root :  1 left  :  2 right
      if(nodes[chars[0]] == null) nodes[chars[0]] = new Node();
      if(chars[1]!='*'){
        nodes[chars[0]].left = chars[1];
        if(nodes[chars[1]] == null) nodes[chars[1]] = new Node();
        nodes[chars[1]].father = chars[0];
      }
      if(chars[2]!='*'){
        nodes[chars[0]].right = chars[2];
        if(nodes[chars[2]] == null) nodes[chars[2]] = new Node();
        nodes[chars[2]].father = chars[0];
      }
    }
    int root = 0;
    for (int i = 0; i <128 ; i++) {
      if(nodes[i]!= null && nodes[i].father == 0){
        root = i;break;
      }
    }
    vis(root);
  }
  public static void vis(int root){
    System.out.print((char)root);
    if(nodes[root].left != 0) vis(nodes[root].left);
    if(nodes[root].right != 0) vis(nodes[root].right);
  }
}
