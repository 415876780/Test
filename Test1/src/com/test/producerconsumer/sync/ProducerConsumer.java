package com.test.producerconsumer.sync;

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
    synchronized void put()//生产  
    {  
        while(index == 6 )//判断是否满  
        {  
            try   
            {  
                wait();  
            }   
            catch (InterruptedException e)   
            {  
                e.printStackTrace();  
            }  
        }  
        index ++;  
        System.out.println("生产1个，剩余"+index+"个");  
        notifyAll();  
    }  
    synchronized void get()//消费  
    {  
        while(index == 0)//判断是否空  用if的话太多线程的请看看下有bug  
        try  
        {  
            wait();  
        }  
        catch(InterruptedException e)  
        {  
            e.printStackTrace();  
        }  
        index--;  
        System.out.println("消费1个，剩余" +index+"个");  
        notifyAll();  
    }  
} 
