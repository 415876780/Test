package com.test.longestdistance;

public class LongestDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestDistance().getDis(new int[]{5386,5384,11054,6345,5816,11757}, 6));
	}
	public int getDis(int[] A, int n) {
        // write code here
		int min=0;
		for(int i=0;i<n-1;i++){
			int min1=0;
			for(int j=i;j<n-1;j++){
				int a= A[j+1]-A[i];
				min1=a>min1?a:min1;
			}
			min=min1>min?min1:min;
		}
		return min;
		
    }
}
