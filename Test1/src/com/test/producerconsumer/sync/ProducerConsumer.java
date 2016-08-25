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
    final int num = 6;//����Ϊ6   
    int index = 0;  
    synchronized void put()//����  
    {  
        while(index == 6 )//�ж��Ƿ���  
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
        System.out.println("����1����ʣ��"+index+"��");  
        notifyAll();  
    }  
    synchronized void get()//����  
    {  
        while(index == 0)//�ж��Ƿ��  ��if�Ļ�̫���̵߳��뿴������bug  
        try  
        {  
            wait();  
        }  
        catch(InterruptedException e)  
        {  
            e.printStackTrace();  
        }  
        index--;  
        System.out.println("����1����ʣ��" +index+"��");  
        notifyAll();  
    }  
} 
