package com.test.bigdataadd;

import java.util.ArrayList;
import java.util.List;
/*
 * 大整数的加法和乘法
 * 
 * */
public class BigDataComputer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mulity("111","11"));
	}
	public static String add(String data1,String data2){
		String result="";
		int maxLength = data1.length()>=data2.length()?data1.length():data2.length();
		int index = maxLength-1;
		int carry =0 ;
		while(data1.length()<maxLength){
			data1="0"+data1;
		}
		while(data2.length()<maxLength){
			data2="0"+data2;
		}
		while(index>=0){
			int first= Integer.valueOf(data1.substring(index,index+1));
			int second = Integer.valueOf(data2.substring(index,index+1));
			result+= (first+second + carry)%10;
			carry= (first+second+ carry)/10;
			index--;
		}
		if(carry!=0){
			result+= carry;
		}
		return revert(result);
	}
    public static String revert(String string){  
        char[] charArray = new char[string.length()];  
        for(int i = 0; i < string.length(); i++){  
            charArray[i] = string.charAt(string.length() - 1 - i);  
        }  
        return new String(charArray);  
    }  
    public static String mulity(String data1,String data2){
    	String result="";
    	for(int i=0;i<data2.length();i++){
    		int n=Integer.valueOf(data2.substring(data2.length()-i-1,data2.length()-i));
    		String sum="";
    		for(int j=0;j<n;j++ ){
    			sum=add(sum,data1);
    		}
    		for(int k=0;k<i;k++){
    			sum+="0";
    		}
    		result=add(result,sum);
    	}
    	return result;
    }
}
