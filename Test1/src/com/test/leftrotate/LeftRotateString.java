package com.test.leftrotate;

public class LeftRotateString {
	public static void main(String[] args) {
		System.out.println(change("abcdefgh".toCharArray(),3));
	}

	public static char[] change(char[] c,int k){
		for(int i=0;i<k/2;i++){
			/*c[i]^=c[j]^=c[i]^=c[j];*/
			int j = k-i-1;
			c[i]=(char) (c[i]+c[j]);
			c[j]=(char) (c[i]-c[j]);
			c[i]=(char) (c[i]-c[j]);
			
		}
		for(int n=0;n<(c.length-k)/2;n++){
			int j=c.length-1-n;
			int i=k+n;
			c[i]=(char) (c[i]+c[j]);
			c[j]=(char) (c[i]-c[j]);
			c[i]=(char) (c[i]-c[j]);
		}
		for(int i=0;i<c.length/2;i++){
			int j=c.length-1-i;
			c[i]=(char) (c[i]+c[j]);
			c[j]=(char) (c[i]-c[j]);
			c[i]=(char) (c[i]-c[j]);
		}
		return c;
	}
}