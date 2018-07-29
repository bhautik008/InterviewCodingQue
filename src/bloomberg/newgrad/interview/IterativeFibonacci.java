package bloomberg.newgrad.interview;

public class IterativeFibonacci {
	
	private static int iterativeFibonacci(int n) {
		if(n <= 1) return n;
		int fib = 1, prevFib = 1;
		for(int i=2;i<n;i++) {
			int temp = fib;
			fib += prevFib;
			prevFib = temp;
		}
		return fib;
	}
	
	private static int fibonacci(int n) {
		if(n<=1) return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static void main(String[] args) {
		System.out.println("Recursive Fibonacci of 10: "+fibonacci(10)+"\n"
				+ "Iterative Fibonacci of 10: "+iterativeFibonacci(10));
	}
}
