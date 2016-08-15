package com.test.binarySearch;

import java.util.Scanner;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        // write code here
    	if(n==0) return -1;
    	int start=0;
    	int end=n-1;
    	int middle=(end+start)/2;
    	while(end>start){
    		if(A[middle]>val){
    			end=middle-1;
    			middle=(start+end)/2;
    		}
    		if(A[middle]<val){
    			start=middle+1;
    			middle= (end+start)/2;
    		}
    		if(A[middle]==val){
    			while(middle>0){
    				middle--;
    				if(A[middle]!=val)return middle+1;
    			}
    			if(middle==0) return middle;
    		}
    	}
    	return -1;
    }
    public static void main(String[] args) {
		//System.out.println(new BinarySearch().getPos(new int[]{9,13,21,31}, 4, 9));
    	
    	Scanner sc = new Scanner(System.in);
    	
	}
    
}
