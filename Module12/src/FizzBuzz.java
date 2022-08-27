
public class FizzBuzz {

	static int num = 1;

	static StringBuilder fizzBuzzPrinter = new StringBuilder();

	public static void main(String[] args) throws InterruptedException {

		for (int i = 1; i <= 15; i++) {		
			fizzBuzzThreads();
			num++;
		}

		System.out.println(fizzBuzzPrinter.substring(0,fizzBuzzPrinter.length()-2).toString());
	}
	
	private static void fizzBuzzThreads() throws InterruptedException {
		Thread threadA = new Thread(() -> {
			if (num % 3 == 0 && num % 5 != 0) {
				fizzBuzzPrinter.append("fizz, ");
			}
		});
		threadA.start();
		threadA.join();
		
		Thread threadB = new Thread(() -> {
			if (num % 3 != 0 && num % 5 == 0) {
				fizzBuzzPrinter.append("buzz, ");
			}
		});
		threadB.start();
		threadB.join();
		
		Thread threadC = new Thread(() -> {
			if (num % 15 == 0) {
				fizzBuzzPrinter.append("fizzbuzz, ");
			}
		});
		threadC.start();
		threadC.join();
		
		Thread threadD = new Thread(() -> {
			if (num % 15 != 0) {
				fizzBuzzPrinter.append(num).append(", ");
			}
		});
		threadD.start();
		threadD.join();
	}

}
