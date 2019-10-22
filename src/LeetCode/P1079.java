package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class P1079 {
  public static void main(String[] args) {

  }

  public static int numTilePossibilities(String tiles) {
    boolean[] vis = new boolean[tiles.length()];
    Set<String> set = new HashSet<>();
    dfs(vis,set,tiles,new StringBuffer());
    return set.size()-1;
  }
  public static void dfs(boolean[] vis,Set<String> set,String tiles,StringBuffer res){
    set.add(res.toString());
    for (int i = 0; i < tiles.length() ; i++) {
      if(!vis[i]){
        vis[i] = true;
        res.append(tiles.charAt(i));
        dfs(vis,set,tiles,res);
        res.deleteCharAt(res.length()-1);
        vis[i] = false;
      }
    }
  }
}
