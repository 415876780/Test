package com.test.cyclibarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierTest {
	 CyclicBarrier c = new CyclicBarrier(1,new A());
	public static void main(String[] args) {
		new CyclicBarrierTest().test();
		AtomicInteger ai = new AtomicInteger(1);
		ai.addAndGet(1);
	}
	public void test(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(1);
				try {
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(2);
	}
	 class A implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(3);
		}
		
	}
}
