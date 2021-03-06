import java.util.Scanner;

public class evenOdd {

	void findEvens(int x) {
		System.out.print("Even Nos:");
		for (int i = 1; i <= x; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	void findOdds(int x) {
		System.out.print("Odd Nos:");
		for (int i = 1; i <= x; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void main(String args[]) throws InterruptedException {
		System.out.print("Enter Range 1-");
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		evenOdd obj = new evenOdd();
		threadOne even = new threadOne(obj, num);
		even.start();
		threadTwo odd = new threadTwo(obj, num);
		odd.start();
		sc.close();

	}
}

class threadOne extends Thread {
	evenOdd e;
	int x;

	threadOne(evenOdd e, int x) {
		this.e = e;
		this.x = x;

	}

	public void run() {
		e.findEvens(x);
	}
}

class threadTwo extends Thread {
	evenOdd o;
	int x;

	threadTwo(evenOdd o, int x) {
		this.o = o;
		this.x = x;

	}

	public void run() {
		o.findOdds(x);
	}
}
