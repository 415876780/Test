package com.test.firstrepeat;

import java.util.HashMap;

public class FirstRepeat {
	public static void main(String[] args) {
		System.out.println(new FirstRepeat().findFirstRepeat("qywyer23tdd", 11));
	}
	 public char findFirstRepeat(String A) {
	        // write code here
		 char[] chars= A.toCharArray();
		 HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		 char result = 0;
		 for(char c:chars){
			 if(map.containsKey(c)){
				 result=c;
				 break;
			 }else{
				 map.put(c, 1);
			 }
		 }
		return result; 
	 }
	 
	public char findFirstRepeat(String A, int n) {
		// write code here
		char[] chars = A.toCharArray();
		char result = 0;
		char[] hash = new char[256];
		for (char c : chars) {
			if (hash[c] == 1) {
				result = c;
				break;
			} else {
				hash[c] = 1;
			}
		}
		return result;
	}
}
