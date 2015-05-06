package demo.service;

public class SleepService implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
