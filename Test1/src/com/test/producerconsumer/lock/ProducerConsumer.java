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
    final int num = 6;//����Ϊ6   
    int index = 0;  
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();
    public void put(){//����  
    	lock.lock();
		try {
				while (index == 6){// �ж��Ƿ���
					full.await();//wait();
				}
				index ++;  
				System.out.println("����1����ʣ��"+index+"��");  
				empty.signal();//notifyAll();  
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
    }  
    public void get()//����  
    {  
    	lock.lock();
        try {
			while(index == 0){//�ж��Ƿ��  ��if�Ļ�̫���̵߳��뿴������bug  
			   empty.await();// wait();  
			}
			index--;  
	        System.out.println("����1����ʣ��" +index+"��");  
	        full.signal();// notifyAll();  
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  
} 
