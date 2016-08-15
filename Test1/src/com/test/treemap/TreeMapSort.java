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
		// ����TreeMap���ϣ�����ͨ��tr�ļ���map�����е�ֵ��������
		TreeMap<String, Integer> tr = new TreeMapSort().MapSort(map);
		tr.putAll(map);
		System.out.println(map);
		System.out.println(tr);
	}
	// �Զ���Ƚ���
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
			// ͨ��TreeMap��key���ҵ�Map������value��Ȼ��Ϳ��Զ���value����
			int num = mp.get(o2).compareTo(mp.get(o1));
			// ��ֵ��ͬ����Ƚϼ�
			if (num == 0) {
				return o2.compareTo(o1);
			}
			return num;
		}

	}
}
