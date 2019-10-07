package LuoGu;

import java.util.Scanner;

public class P1030 {
  static String mid;
  static String last;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    mid = sc.next();
    last = sc.next();
    dfs(0,mid.length()-1,0,last.length()-1);
  }
  public static void dfs(int l1,int r1,int l2,int r2){
    if(l1>r1) return;
    System.out.print(last.charAt(r2));        // 先序遍历 直接输出节点
    int index = l1;
    while (mid.charAt(index) != last.charAt(r2)) index++;   //找到中序的切分点 分为左子树和右子数
    int count = index-l1;           //
    dfs(l1,index-1,l2,l2+count-1);    // 左子树
    dfs(index+1,r1,l2+count,r2-1);  // 右子树
  }
}
