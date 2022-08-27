
public class SecondsCounter {

	private static void oneSecondThread() throws InterruptedException {

		for (int i = 1; i <= 50; i++) {
			Thread.sleep(1000);
			if (i == 1)
				System.out.println(i + " second has been passed");
			if (i > 1)
				System.out.println(i + " seconds have been passed");
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread fiveSecondsThread = new Thread(new FiveSecondsThread());
		fiveSecondsThread.start();
		oneSecondThread();

	}

}

class FiveSecondsThread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Five seconds have passed with a total of " + i * 5 + " seconds ");

		}

	}

}
