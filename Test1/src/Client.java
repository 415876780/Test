
public class Client {
	public static void main(String[] args) {
		Data data = new Data(10);
		
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		
		new WriterThread(data,"ABCDEFGHI").start();
		new WriterThread(data,"0123456789").start();
		
	}
}
