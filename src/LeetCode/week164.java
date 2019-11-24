package LeetCode;

import java.util.*;

/**
 * @author kid1999
 * @title: week164
 * @date 2019/11/24 10:29
 */

public class week164 {
	public static void main(String[] args) {

	}

	public int minTimeToVisitAllPoints(int[][] points) {
		int res = 0;
		int x = points[0][0];
		int y = points[0][1];
		for (int i = 1; i <points.length ; i++) {
			int x_len = Math.abs(points[i][0] - x);
			int y_len = Math.abs(points[i][1] - y);
			res += Math.max(x_len,y_len);
			x = points[i][0];
			y = points[i][1];
		}
		return res;
	}


	// 2
	public int countServers(int[][] grid) {
		int res = 0;
		int n = grid.length;
		int m = grid[0].length;
		boolean vis[][] = new boolean[n][m];
		for (int i = 0; i < n ; i++) {
			int count = 0;
			int sum = 0;
			for (int j = 0; j < m ; j++) {
				if(grid[i][j] == 1){
					count++;
					if(!vis[i][j]) sum++;
				}
			}
			if(count>1){
				res += sum;
				for (int j = 0; j < m ; j++) {
					vis[i][j] = true;
				}
			}
		}

		for (int j = 0; j < m ; j++){
			int count = 0;
			int sum = 0;
			for (int i = 0; i < n ; i++) {
				if(grid[i][j] == 1){
					count++;
					if(!vis[i][j]) sum++;
				}
			}
			if(count>1){
				res += sum;
				for (int i = 0; i < n ; i++) {
					vis[i][j] = true;
				}
			}
		}
		return res;
	}

	// 3
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> res = new ArrayList<>();
		List<String> prod = new LinkedList<>();
		for (int i = 0; i < products.length; i++) {
			prod.add(products[i]);
		}

		for (int i = 0; i <searchWord.length() ; i++) {
			List<String> list = new ArrayList<>();
			char word = searchWord.charAt(i);
			for (int j = 0; j < prod.size() ; j++) {
				if(prod.get(j).length() >= 1 && prod.get(j).charAt(0) == word){
					if(prod.get(j).length() == 1) list.add("");
					else list.add(prod.get(j).substring(1));
				}
			}
			list.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			System.out.println(list);
			res.add(list);
			prod = list;
		}

		List<List<String>> result = new ArrayList<>();
		for (int i = 0; i < searchWord.length() ; i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; j < 3 ; j++) {
				if(j<res.get(i).size()){
					list.add(searchWord.substring(0,i+1) + res.get(i).get(j));
				}
			}
			result.add(list);
		}
		return result;
	}
}

