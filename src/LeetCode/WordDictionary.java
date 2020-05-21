package LeetCode;

/**
 * @author kid1999
 * @title: WordDictionary -- 添加和搜索单词 -- 前缀树的应用
 * @date 2020/5/21 12:52
 */

class WordDictionary {
	private static class Node{
		public boolean isWord;
		public Node[] next = new Node[26];
	}

	private Node node;


	public WordDictionary() {
		node = new Node();
	}


	public void addWord(String word) {
		Node root = node;
		for(char c : word.toCharArray()){
			if(root.next[c-'a'] == null)
				root.next[c-'a'] = new Node();
			root = root.next[c-'a'];
		}
		root.isWord = true;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		Node root = node;
		return dfs(root,word,0);
	}

	private boolean dfs(Node cur,String word,int index){
		if(index == word.length()) return cur.isWord;
		if(word.charAt(index) != '.'){
			if(cur.next[word.charAt(index)-'a'] == null)
				return false;
			return dfs(cur.next[word.charAt(index)-'a'],word,index+1);
		}else {
			for(Node n:cur.next){
				if(n != null && dfs(n,word,index+1))
					return true;
			}
		}
		return false;
	}
}
