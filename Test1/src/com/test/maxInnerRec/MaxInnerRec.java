package com.test.maxInnerRec;

public class MaxInnerRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MaxInnerRec().countArea(new int[]{2,7,9,4,1},5));
	}
	public int countArea(int[] A, int n) {
        // write code here
		int max=0;
		for(int i =0;i<A.length;i++){
			int sum =0;
			int m=n=i;
			int k=0;
			while(m>0){
				if(A[m-1]>=A[i]){
					k++;
				}else{
					break;
				}
				m--;
			}
			while(n<A.length){
				if(A[n]>=A[i]){
					k++;
				}else{
					break;
				}
				n++;
			}
			sum = k*A[i];
			max=sum>max?sum:max;
		}
		return max;
    }


}
