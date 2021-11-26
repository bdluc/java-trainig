package thread.java;

public class ThreadCountUp implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread Up: " + i);
		}
	}

}
