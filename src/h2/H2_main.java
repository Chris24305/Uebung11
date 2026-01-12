package h2;

public class H2_main {
	public static void main(String[] args) {
		benchmark(10);
		benchmark(20);
	}

	public static int fibonacci(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int fibonacciIterativ(int n) {
		int fibn = 1, fibalt = 1, fibneu = 1;
		if (n == 1)
			return 1;
		for (int i = 2; i < n; i++) {
			fibneu = fibn + fibalt;
			fibalt = fibn;
			fibn = fibneu;
		}
		return fibn;
	}

	public static int fibonacciCached(int n) {
		if (n == 1 || n == 2) {
			fibCache[n] = 1;
			return fibCache[n];
		}
		if (fibCache[n] != 0)
			return fibCache[n];
		fibCache[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
		return fibCache[n];
	}

	public static void benchmark(int n) {
		long a, b;
		a = System.nanoTime();
		fibonacci(n);
		b = System.nanoTime();
		b -= a;
		System.out.println("Elapsed nanoseconds (fibonacci): " + b);

		a = System.nanoTime();
		fibonacciCached(n);
		b = System.nanoTime();
		b -= a;
		System.out.println("Elapsed nanoseconds (fibonacciCached): " + b);

		a = System.nanoTime();
		fibonacciIterativ(n);
		b = System.nanoTime();
		b -= a;
		System.out.println("Elapsed nanoseconds (fibonacciIterativ): " + b);
	}

	public static int[] fibCache = new int[1000];
}
