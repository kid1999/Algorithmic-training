package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author kid1999
 * @title: P146  --   LRU (最近最少使用) 缓存机制
 * @date 2020/5/25 14:27
 */

public class P146 {

	// 法一：队列+ hashMap
	// class LRUCache {
//     private int capacity;
//     private HashMap<Integer,Integer> cache;
//     private Queue<Integer> queue;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         cache = new HashMap<>();
//         queue = new LinkedList<>();
//     }

//     public int get(int key) {
//         if(!cache.containsKey(key)) return -1;
//         else{
//             queue.remove(key);
//             queue.add(key);
//             return cache.get(key);
//         }
//     }

//     public void put(int key, int value) {
//         if(cache.containsKey(key)) {
//             queue.remove(key);
//         }else if(capacity == 0) cache.remove(queue.poll());
//         else capacity--;

//         queue.add(key);
//         cache.put(key,value);
//     }
// }


	// 法二：java自带的LinkedHashMap 有序map
	private static class LRUCache {
		int capacity;
		LinkedHashMap<Integer, Integer> cache;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
				@Override
				protected boolean removeEldestEntry(Map.Entry eldest) {
					return cache.size() > capacity;
				}
			};
		}

		public int get(int key) {
			return cache.getOrDefault(key, -1);
		}

		public void put(int key, int value) {
			cache.put(key, value);
		}
	}
}
