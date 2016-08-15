package com.local.test;

public class SequenceB implements Sequence {

	public static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>(){
		protected Integer initialValue(){
			return 0;
		}
	};
	
	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		numberContainer.set(numberContainer.get()+1);
		return numberContainer.get();
	}
	 public static void main(String[] args) {
	        Sequence sequence = new SequenceB();
	 
	        ClientThread thread1 = new ClientThread(sequence);
	        ClientThread thread2 = new ClientThread(sequence);
	        ClientThread thread3 = new ClientThread(sequence);
	 
	        thread1.start();
	        thread2.start();
	        thread3.start();
	    }

}
