package com.test.maxsubstr;

public class MaxSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxString("abcdef","bacadf"));
	}
	public static String getMaxString(String s1,String s2){
		char[] c1=s1.toCharArray();
		char[] c2= s2.toCharArray();
		int n1= s1.length();
		int[][] a  = new int[s1.length()][s2.length()];
		int max=0;
		int k=0;
		for(int i =0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(c1[i]==c2[j]){
					if(i-1>=0&&j-1>=0){
						a[i][j]=a[i-1][j-1]+1;
					}else{
						a[i][j]=1;
					}
				}else{
					a[i][j]=0;
				}
				if(a[i][j]>max){
					max=a[i][j];
					k=j;
				}
			}
		}
		return s2.substring(k-max+1, k+1);
	}
}
