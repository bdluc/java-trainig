package thread.java;

public class ThreadCountDown extends Thread{
	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread Down: " + i);
		}
	}
}
