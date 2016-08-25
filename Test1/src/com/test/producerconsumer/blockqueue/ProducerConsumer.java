package com.test.producerconsumer.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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

    public BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(6);
    public void put(){ //生产  
        try {
			queue.put(1);
			 System.out.println("生产1个，剩余"+queue.size()+"个");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    }  
    public void get()//消费  
    {  
        try {
			queue.take();
			System.out.println("消费1个，剩余" +queue.size()+"个");  
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }  
} 
