package com.test.coder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Coder {
	public static void main(String[] args) {
		new Coder().equals("");
		new Coder().findCoder(new String[]{"coder","dccoderrlcoderxxpicoderhcoderbiwcoderdcoderrcodermcoderdbvcodertrwvycoderimvcoderuswfccoderczecoderczncoderkfuehcoderocoderiuvccoderfwcodervdiycoderifqjcoder","vxroicoderdqcoderfvcodermtyrcoderlcoderwrygcoder","hcoderwzmjccoderamfmvcoderazmcoderhcodersnuccoderceocodermsmifcoderpwpcodertqbqcoderentbcoderxsgpkcoderrqrbcoderucoder"}, 3);
	}
	 public String[] findCoder(String[] A, int n) {
	        // write code here
		 HashMap<String,Integer> map = new HashMap<String,Integer>();
		 for(String s:A){
			if(isContain(s)!=0){
				map.put(s, isContain(s));
			}
		}
		 TreeMap<String,Integer> tree = mapSort(map);
		String[] ss= new String[tree.size()];
		 System.out.println(tree);
		int i=0;
		for(String s:tree.keySet()){
			ss[i++]=s;
		}
		 return ss;
	 }

	private int isContain(String s) {
		// TODO Auto-generated method stub
		s=s.toLowerCase();
		int index=0;
		int i=0;
		while(index>=0){
			index=s.indexOf("Coder".toLowerCase());
			if(index!=-1){
				s=s.substring(index+"coder".length());
				i++;
			}
		}
		return i;
	}
	public TreeMap<String, Integer> mapSort(Map<String,Integer> map){
		TreeMap<String, Integer> tr = new TreeMap<String, Integer>(new Compare(map));
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
