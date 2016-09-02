package com.test.quicksort;
/*
 * ¿ìËÙÅÅĞò
 * 
 * */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{6,4,2,5,3,1,8,7};
		new QuickSort().quicksort(a,0,7);
		for(int i:a){
			System.out.println(i);
		}
	}
	public void quicksort(int[] a,int start,int end){
		if(start<end){
			int n = sort(a,start,end);
			quicksort(a,start,n-1);
			quicksort(a,n+1,end);
		}
	}
	
	public int sort(int[] a ,int start, int end){
		int flag= a[start];
		while(start<end){
			while(start<end&&a[end]>=flag) end--;
			 a[start]=a[end];
			 while(start<end&&a[start]<=flag) start++;
			 a[end]=a[start];
		}
		a[end]=flag;
		return end;
	}

}
