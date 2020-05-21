package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author kid1999
 * @title: Trie - 前缀树
 * @date 2020/5/21 8:49
 */

// 基于hash的简单实现前缀树的功能
//class Trie {
//	private HashSet<String> words; // 单词集合
//	private HashSet<String> pres;   // 前缀集合
//	/** Initialize your data structure here. */
//	public Trie() {
//		words = new HashSet<>();
//		pres = new HashSet<>();
//	}
//
//	/** Inserts a word into the trie. */
//	public void insert(String word) {
//		words.add(word);
//		for (int i = 1; i <=word.length() ; i++) {
//			pres.add(word.substring(0,i));
//		}
//	}
//
//	/** Returns if the word is in the trie. */
//	public boolean search(String word) {
//		return words.contains(word);
//	}
//
//	/** Returns if there is any word in the trie that starts with the given prefix. */
//	public boolean startsWith(String prefix) {
//		return pres.contains(prefix) && !words.contains(prefix);
//	}
//}



// 前缀树
//public class Trie {
//	private boolean is_string = false;
//	private Trie[] next = new Trie[26];
//
//	public Trie(){}
//
//	public void insert(String word){//插入单词
//		Trie root = this;
//		for (char c : word.toCharArray()) {
//			if (root.next[c - 'a'] == null) root.next[c - 'a'] = new Trie();
//			root = root.next[c - 'a'];
//		}
//		root.is_string = true;
//	}
//
//	public boolean search(String word){//查找单词
//		Trie root = this;
//		for (char c : word.toCharArray()) {
//			if (root.next[c - 'a'] == null) return false;
//			root = root.next[c - 'a'];
//		}
//		return root.is_string;
//	}
//
//	public boolean startsWith(String prefix){//查找前缀
//		Trie root = this;
//		for (char c : prefix.toCharArray()) {
//			if (root.next[c - 'a'] == null) return false;
//			root = root.next[c - 'a'];
//		}
//		return true;
//	}
//}



// 基于map的前缀树
public class Trie {
	private boolean is_string = false;
	private HashMap<Character,Trie> next;

	public Trie(){
		this.next = new HashMap<>();
	}

	public void insert(String word){//插入单词
		Trie root = this;
		for (char c : word.toCharArray()) {
			if(!root.next.containsKey(c))
				root.next.put(c,new Trie());
			root = root.next.get(c);
		}
		root.is_string = true;
	}

	public boolean search(String word){//查找单词
		Trie root = this;
		for (char c : word.toCharArray()) {
			if (!root.next.containsKey(c)) return false;
			root = root.next.get(c);
		}
		return root.is_string;
	}

	public boolean startsWith(String prefix){//查找前缀
		Trie root = this;
		for (char c : prefix.toCharArray()) {
			if (!root.next.containsKey(c)) return false;
			root = root.next.get(c);
		}
		return true;
	}
}