package com.test.treemap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapSort {
	public static void main(String[] args) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 2);
		// 声明TreeMap集合，可以通过tr的键对map集合中的值进行排序
		TreeMap<String, Integer> tr = new TreeMapSort().MapSort(map);
		tr.putAll(map);
		System.out.println(map);
		System.out.println(tr);
	}
	// 自定义比较器
	public TreeMap<String, Integer> MapSort(Map<String,Integer> map){
		TreeMap<String, Integer> tr = new TreeMap<String, Integer>(new Compare(
				map){
		});
		tr.putAll(map);
		return tr;
		
	}
	public  class Compare implements Comparator<String> {
		private Map<String, Integer> mp;
		Compare(Map<String, Integer> mp) {
			this.mp = mp;
		}
		public int compare(String o1, String o2) {
			// 通过TreeMap的key来找到Map集合中value，然后就可以对其value排序
			int num = mp.get(o2).compareTo(mp.get(o1));
			// 若值相同，则比较键
			if (num == 0) {
				return o2.compareTo(o1);
			}
			return num;
		}

	}
}
