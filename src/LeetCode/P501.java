package LeetCode;

import java.util.*;

/**
 * @author kid1999
 * @date 2020/9/24 20:31
 * @title P501
 */

public class P501 {
	public static void main(String[] args) {

	}

	Map<Integer,Integer> map;
	int max = 0;
	public int[] findMode(TreeNode root) {
		map = new HashMap<>();
		dfs(root);

		int len = 0;
		for (Map.Entry<Integer,Integer> entry:map.entrySet()){
			if(entry.getValue() == max) len++;
		}
		int[] tmp = new int[len];
		len = 0;
		for (Map.Entry<Integer,Integer> entry:map.entrySet()){
			if(entry.getValue() == max) tmp[len++] = entry.getKey();
		}
		return tmp;
	}

	public void dfs(TreeNode root){
		if(root == null) return;
		int count = map.getOrDefault(root.val,0)+1;
		max = Math.max(max,count);
		map.put(root.val,count);
		dfs(root.left);
		dfs(root.right);
	}

}
