package kid1999.io.week153;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test2 {
	public static void main(String[] args) {
//		System.out.println(countLetters("aaaaaaaaaa"));
		String[] s = {"mission statement",
		                "a quick bite to eat",
		                "a chip off the old block",
		                "chocolate bar",
		                "mission impossible",
		                "a man on a mission",
		                "block party",
		                "eat my words",
		                "bar of soap"};//{"writing code","code rocks"}; //{"a","b","a"}; //
		for(String ss: beforeAndAfterPuzzles(s)) {
			System.out.println(ss);
		}
	}
//	public static int countLetters(String S) {
//	    if(S.length() == 1) return 1;
//	    int res  = 1;
//	    int count = 1;
//	    System.out.println(S.charAt(0));
//	    for(int i=1;i<S.length();i++){
//	      if(S.charAt(i) == S.charAt(i-1)){
//	        count++;
//	      }else{
//	        count = 1;
//	      }
//	      res += count;
//	    }
//	    return res;
//	  }
	
	public static String[] beforeAndAfterPuzzles(String[] phrases) {
	    List<String> res = new ArrayList<>();
	    Map<String,List<String>> headmap = new HashMap<>();
	    Map<String,List<String>> endmap = new HashMap<>();
	    Set<String> used = new HashSet<>();
	    for(String str : phrases){
	      String[] ss = str.split(" ");
	      String start = ss[0];
	      String detail = ss[ss.length-1];
	      if(!headmap.containsKey(start)) {
	    	  List<String> tmp = new ArrayList<>();
	    	  tmp.add(str.substring(start.length()));
	    	  headmap.put(start,tmp);
	      }else {
	    	  List<String> tmp = headmap.get(start);
	    	  tmp.add(str.substring(start.length()));
	    	  headmap.put(start,tmp); 
	      }
	      if(!endmap.containsKey(detail)) {
	    	  List<String> tmp = new ArrayList<>();
	    	  tmp.add(str);
	    	  endmap.put(detail,tmp);
	      }else {
	    	  List<String> tmp = endmap.get(detail);
	    	  tmp.add(str);
	    	  endmap.put(detail,tmp);
	      }
	    }
	    for(String end : endmap.keySet()) {
	    	if(headmap.containsKey(end)) {
	    		int a = endmap.get(end).size();
	    		for(String detail : endmap.get(end)) {
    			int b = detail.length();
	    		int c = headmap.get(end).size();
	    		for(String head : headmap.get(end)) {
	    			if(!used.contains(detail + head) && (a != 1 || b!=1 || c!=1)) {
	    				res.add(detail + head);
	    				used.add(detail + head);
	    			}
	    		}
	    		}
	    	}
	    }
	    String[] result = new String[res.size()];
	    for(int i=0;i<res.size();i++) {
	    	result[i] = res.get(i);
	    }
	    return result;
	  }
}
