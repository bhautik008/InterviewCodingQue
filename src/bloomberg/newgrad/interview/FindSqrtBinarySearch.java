package bloomberg.newgrad.interview;

/*
 * Approximate the square root of a number using binary search
 */

public class FindSqrtBinarySearch {

	private static double findSQRT(double n) {
		return findSQRTrec(n, 1, n);
	}

	private static double findSQRTrec(double n, double start, double end) {
		double mid = (start + end) / 2;
		if (mid * mid == n) {
			return mid;
		} else if (findDecimals(mid) > 5) {
			return mid;
		} else if (mid * mid < n) {
			return findSQRTrec(n, mid, end);
		} else {
			return findSQRTrec(n, start, mid);
		}
	}

	private static int findDecimals(double d) {
		String text = Double.toString(Math.abs(d));
		int integerPlaces = text.indexOf('.');
		return text.length() - integerPlaces - 1;
	}

	public static void main(String[] args) {
		System.out.println("approzimate Square root of 16 is " + findSQRT(16));
	}
}
