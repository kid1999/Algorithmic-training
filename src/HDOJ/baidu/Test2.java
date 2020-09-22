package HDOJ.baidu;

import javafx.util.Pair;

import java.util.*;

class TreeNode {
   int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class Test2 {
	public static void main(String[] args) {
		int[][] arr = {{1,0,1},{0,0,0},{1,0,1}};
		System.out.println(maxDistance(arr));
	}
	public  static int countCharacters(String[] words, String chars) {
		int[] cs = new int[26];
		int res = 0;
		for (char c: chars.toCharArray()) {
			cs[c-'a']++;
		}
		for(String word : words){
			boolean f = false;
			for (char c:word.toCharArray()){
				cs[c -'a']--;
				if(cs[c -'a'] < 0) f = true;
			}
			for (char c:word.toCharArray()){
				cs[c -'a']++;
			}
			if(!f) res += word.length();
		}
		return res;
	}

	public int maxLevelSum(TreeNode root) {
		int max = Integer.MIN_VALUE;
		int res = 0,index = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()){
			index++;
			int size = q.size();
			int sum = 0;
			for (int i = 0; i <size ; i++) {
				TreeNode node = q.poll();
				if(node == null) continue;
				sum += node.val;
				if(node.left!=null) q.offer(node.left);
				if(node.right!=null) q.offer(node.right);
			}
			if(sum > max){
				max = sum;
				res = index;
			}
		}
		return res;
	}



	// 用1 搜 0
	public static int maxDistance(int[][] grid) {
		int max = -1;
		int dis = -1;
		for(int i = 0; i< grid.length;i++){
			for(int j=0;j<grid.length;j++){
				if(grid[i][j] == 1){
					Set<Pair<Integer,Integer>> set = new HashSet<>();
					dis =  func(grid,i,j);
					if(dis >max) max = dis;
				}
			}
		}
		return max;
	}

	// 递归 感染函数
	public static int func(int[][] grid,int y,int x) {
		int max = 0;
		int cout = -1;
		Queue<Pair<Integer, Integer>> q = new LinkedList<>();
		Set<Pair<Integer, Integer>> use = new LinkedHashSet<>();
		q.offer(new Pair<>(y, x));
		use.add(new Pair<>(y, x));
		while (!q.isEmpty()) {
			cout++;
			int size = q.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {
				if (grid[y][x - 1] == 0) sum++;
				if (x - 1 >= 0 && !use.contains(new Pair<>(y, x - 1)) && grid[y][x - 1] != 1) q.offer(new Pair<>(y, x - 1));
				if (x + 1 < grid.length && !use.contains(new Pair<>(y, x + 1)) && grid[y][x - 1] != 1)
					q.offer(new Pair<>(y, x - 1));
				if (y - 1 >= 0 && !use.contains(new Pair<>(y - 1, x)) && grid[y][x - 1] != 1) q.offer(new Pair<>(y, x - 1));
				if (y + 1 < grid.length && !use.contains(new Pair<>(y + 1, x)) && grid[y][x - 1] != 1)
					q.offer(new Pair<>(y, x - 1));
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

}
