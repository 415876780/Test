package com.test.producerconsumer.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer   
{  
    public static void main(String[] args)  
    {     
        Container container = new Container();  
        Producer producer = new Producer(container);  
        Consumer consumer = new Consumer(container);  
        new Thread(producer).start();  
        new Thread(producer).start();  
        new Thread(consumer).start();  
        new Thread(consumer).start();  
    }  
}  
class Producer implements Runnable  
{  
    Container Container;  
    public Producer(Container Container)   
    {  
        this.Container = Container;  
    }  
    @Override  
    public void run()   
    {     
        for(int i = 0;i < 20;i++ )  
        {  
            Container.put();  
            try   
            {  
            	Thread.sleep(1000);
                //Thread.sleep((int)(Math.random() * 2000));  
            }  
            catch (InterruptedException e)   
            {  
                e.printStackTrace();  
            }  
        }  
    }  
  
}  
  
class Consumer implements Runnable  
{  
    Container Container;  
    public Consumer(Container Container)   
    {  
        this.Container = Container;  
    }  
  
    @Override  
    public void run()   
    {     
        for(int i = 0;i < 20; i++ )  
        {  
            Container.get();  
            try   
            {  
            	Thread.sleep(5000);
               // Thread.sleep((int)(Math.random() * 2000));  
            }   
            catch (InterruptedException e)   
            {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
  
class  Container  
{  
    final int num = 6;//容量为6   
    int index = 0;  
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();
    public void put(){//生产  
    	lock.lock();
		try {
				while (index == 6){// 判断是否满
					full.await();//wait();
				}
				index ++;  
				System.out.println("生产1个，剩余"+index+"个");  
				empty.signal();//notifyAll();  
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
    }  
    public void get()//消费  
    {  
    	lock.lock();
        try {
			while(index == 0){//判断是否空  用if的话太多线程的请看看下有bug  
			   empty.await();// wait();  
			}
			index--;  
	        System.out.println("消费1个，剩余" +index+"个");  
	        full.signal();// notifyAll();  
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  
} 
