
public class ReaderThread extends Thread {
	private final Data data;
	public ReaderThread(Data data){
		this.data = data;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("============");
			String result=null;
			result = data.read();
            System.out.println(Thread.currentThread().getName() + " => " + result);
        }
	}
}
