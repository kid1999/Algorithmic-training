package LeetCode;

import javafx.util.Pair;

import java.util.*;

/**
 * @author kid1999
 * @title: week170
 * @date 2020/1/5 10:28
 */

public class week170 {
	public static void main(String[] args) {
		System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
	}

	// 1
	public static String freqAlphabets(String s) {
		Map<String,String> map = new HashMap<>();
		map.put("1","a");
		map.put("2","b");
		map.put("3","c");
		map.put("4","d");
		map.put("5","e");
		map.put("6","f");
		map.put("7","g");
		map.put("8","h");
		map.put("9","i");

		map.put("10#","j");
		map.put("11#","k");
		map.put("12#","l");
		map.put("13#","m");
		map.put("14#","n");
		map.put("15#","o");
		map.put("16#","p");
		map.put("17#","q");
		map.put("18#","r");
		map.put("19#","s");

		map.put("20#","t");
		map.put("21#","u");
		map.put("22#","v");
		map.put("23#","w");
		map.put("24#","x");
		map.put("25#","y");
		map.put("26#","z");

		char[] string = s.toCharArray();
		String res = "";
		for (int i = 0; i < s.length() ; i++) {
			if(i+2<s.length()){
				String word1 = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1)) + String.valueOf(s.charAt(i+2));
				if(map.containsKey(word1)){
					i += 2;
					res += map.get(word1);
				}else{
					res += map.get(String.valueOf(s.charAt(i)));
				}
			}else {
				res += map.get(String.valueOf(s.charAt(i)));
			}

		}
		return res;
	}



	// 2
	public int[] xorQueries(int[] arr, int[][] queries) {
		int[] res = new int[queries.length];
		for (int i = 0; i <queries.length ; i++) {
			int[] qes = queries[i];
			int l = qes[0];
			int r = qes[1];
			int sum = arr[l];
			System.out.println(sum);
			for (int j = l+1; j <=r ; j++) {
				sum ^= arr[j];
			}
			System.out.println(sum);
			res[i] = sum;
		}
		return res;
	}


	// 3
	private static class Node{
		String x;
		int y;
	}
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		List<String> res = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(id);
		for (int i = 0; i < level; i++) {
			int size  = queue.size();
			for (int j = 0; j <size ; j++) {
				int index = queue.poll();
				for (int k = 0; k < friends[index].length; k++) {
					if(!queue.contains(friends[index][k])) queue.add(friends[index][k]);
				}
			}
		}
		if(queue.contains(id)) queue.remove(id);
		System.out.println(queue);
		List<Node> nodes = new ArrayList<>();
		while (!queue.isEmpty()){
			int index = queue.poll();
			List<String> ws = watchedVideos.get(index);
			System.out.println(ws);
			for (int i = 0; i <ws.size() ; i++) {
				String word = ws.get(i);
				boolean f = false;
				for (int j = 0; j < nodes.size() ; j++) {
					if(nodes.get(j).x.equals(word)){
						nodes.get(j).y++;
						f = true;
						break;
					}
				}
				if(!f){
					Node node = new Node();
					node.x = word;
					node.y = 1;
					nodes.add(node);
				}
			}
		}
		Collections.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.y !=  o2.y){
					return o1.y - o2.y;
				}else{
					return o1.x.compareTo(o2.x);
				}
			}
		});
		for (int i = 0; i <nodes.size() ; i++) {
			res.add(nodes.get(i).x);
		}
		return res;
	}




	// 4

}
