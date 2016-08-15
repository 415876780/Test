import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Data {
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock(); // ������д��
    private final Lock readLock = lock.readLock();    // ��ȡ����
    private final Lock writeLock = lock.writeLock();  // ��ȡд��
	
	private final char[] buffer;
	public  Data(int size){
		this.buffer = new char[size];
		for(int i = 0;i<size;i++){
			buffer[i] ='*';
		}
	}
	/*public synchronized String read(){
		StringBuilder result = new StringBuilder();
		for(char c:buffer){
			result.append(c);
		}
		sleep(100);
		return result.toString();
	}
	public synchronized void write(char c){
		for(int i=0;i<buffer.length;i++){
			buffer[i]= c;
			sleep(100);
		}
		System.out.println(c+"------>write over!");
	}*/
	private void sleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private String doRead() {
        StringBuilder result = new StringBuilder();
        for (char c : buffer) {
            result.append(c);
        }
        //sleep(100);
        return result.toString();
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
        }
       // sleep(100);
    }
	
	  public String read()  {
	        readLock.lock(); // ��ȡ����
	        try {
	            return doRead(); // ִ�ж�ȡ����
	        } finally {
	            readLock.unlock(); // ��ȡ����
	        }
	    }

	    public void write(char c)  {
	        writeLock.lock(); // д������
	        try {
	            doWrite(c); // ִ��д�����
	        } finally {
	            writeLock.unlock(); // д�����
	        }
	    }
}
