import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Data {
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock(); // 创建读写锁
    private final Lock readLock = lock.readLock();    // 获取读锁
    private final Lock writeLock = lock.writeLock();  // 获取写锁
	
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
	        readLock.lock(); // 读取上锁
	        try {
	            return doRead(); // 执行读取操作
	        } finally {
	            readLock.unlock(); // 读取解锁
	        }
	    }

	    public void write(char c)  {
	        writeLock.lock(); // 写入上锁
	        try {
	            doWrite(c); // 执行写入操作
	        } finally {
	            writeLock.unlock(); // 写入解锁
	        }
	    }
}
