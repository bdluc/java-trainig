package thread.java;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ThreadCountDown td = new ThreadCountDown();
		td.start();
		td.join(2000);
		ThreadCountUp tu = new ThreadCountUp();
		Thread t = new Thread(tu);
		t.start();
	}
}
