package lanqiao.test2019;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class B {
  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    String str = "0100110001010001";
    List<String> list = new ArrayList<>();
    for(int i=0;i<str.length();i++) {
      for(int j=0;j<=i;j++) {
        String tmp = "";
        for(int k=j;k<=i;k++) {
          tmp += str.charAt(k);
        }
        if(!set.contains(tmp)) {
          set.add(tmp);
          list.add(tmp);
        }
      }
    }
    System.out.println(set.size());
    System.out.println(list);
  }
}
