package com.test.listreverse;

import java.util.ArrayList;
import java.util.List;

public class ListReverse {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LNode node1 = new LNode();
		node1.value=1;
		LNode node2 = new LNode();
		node2.value=2;
		node1.next= node2;
		LNode node3 = new LNode();
		node3.value=3;
		node2.next= node3;
		LNode node4 = new LNode();
		node4.value=4;
		node3.next= node4;
		LNode node5 = new LNode();
		node5.value=5;
		node4.next= node5;
		LNode node6 = new LNode();
		node6.value=6;
		node5.next= node6;
		node6.next=null;
		/*LNode node7 = new LNode();
		node7.value=7;
		node6.next= node7;
		node7.next=null;*/
		reverse(node1);;
	}
	
	public static void reverse(LNode node){
		int length=0;
		LNode node1= node;
		while(node1.next!=null){
			length++;
			node1=node1.next;
		}
		LNode p = node1;
		node1=node;
		for(int i =0;i<(length-1)/2;i++){
			node1= node1.next;
		}
		LNode q= Reverse1(node1.next);
		q.next=null;
		node1.next=p;//将反转的链与之前的链连起来
		while(node!=null){
			System.out.println(node.value);
			node=node.next;
		}
	}
	
	public static LNode Reverse(LNode current)  
	 {  
	     if (current == null || current.next == null) return current;  
	     LNode nextNode = current.next;  
	     current.next = null;  
	     LNode reverseRest = Reverse(nextNode);  
	     nextNode.next = current;  
	     return reverseRest;  
	 }  
	public static LNode Reverse1(LNode current)  
	 {  
		if(current.next==null) return current;
		LNode node = Reverse1(current.next);
		node.next=current;
	     return current;  
	 } 
}
class LNode{
	public int value;
	public LNode next;
}

