package LeetCode;

import java.util.*;

/**
 * @author kid1999
 * @title: P212
 * @date 2020/5/22 10:06
 */

public class P212 {
	public static void main(String[] args) {
		String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
		char[][] board = {
				{'a','b'},{'a','a'}};
		P212 p = new P212();
		System.out.println(p.findWords(board,words));
	}

	// 前缀树 数据结构
	private class Node{
		boolean isWord;
		Node[] next;
		public Node(){
			next = new Node[26];
		}
	}

	HashSet<String> set;
	boolean[][] vis;
	int[] func;
	public List<String> findWords(char[][] board, String[] words) {
		Node root = new Node();
		creatTrie(root,words);
		set = new LinkedHashSet<>();
		vis = new boolean[board.length][board[0].length];
		func = new int[]{-1,0,0,1,1,0,0,-1};
		for (int i = 0; i <board.length ; i++) {
			for (int j = 0; j <board[0].length ; j++) {
				dfs(board,root,i,j,String.valueOf(board[i][j]));
			}
		}
		return new LinkedList<>(set);
	}

	void dfs(char[][] board,Node node,int i,int j,String word){
		int code = searchWord(node,word);
		if( code == 1) set.add(word);
		else if(code == -1) return;
		vis[i][j] = true;
		for (int k = 0; k <4 ; k++) {
			int x = i+func[2*k];
			int y = j+func[2*k+1];
			if(x>=0&&y>=0&&x<board.length&&y<board[0].length && !vis[x][y]){
				dfs(board,node,x,y,word+board[x][y]);
			}
		}
		vis[i][j] = false;
	}




	void creatTrie(Node node,String[] words){
		for(String s:words){
			Node root = node;
			for(char c:s.toCharArray()){
				if(root.next[c-'a'] == null)
					root.next[c-'a'] = new Node();
				root = root.next[c-'a'];
			}
			root.isWord = true;
		}
	}

	int searchWord(Node node,String word){
		Node root = node;
		for(char c:word.toCharArray()){
			if(root.next[c-'a'] == null) return -1;
			root = root.next[c-'a'];
		}
		return root.isWord ? 1 : 0;
	}

}
