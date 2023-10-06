package id4673;

public class Main {

	public static void main(String[] args) {
		int[] selfNumber = new int[10000];
		for (int i = 1; i < 10000; i++) {
			selfNumber[i] = i;
		}
		for (int i = 1; i < 10000; i++) {
			for (int n = 1; n < 10; n++) {
				if (i == n * 2) {
					selfNumber[i] = 0;
				}
			}
			for (int n = 10; n < 100; n++) {
				if (i == n + (n % 10) + (n / 10)) {
					selfNumber[i] = 0;
				}
			}
			for (int n = 100; n < 1000; n++) {
				if (i == n + (n % 10) + ((n % 100) / 10) + (n / 100)) {
					selfNumber[i] = 0;
				}
			}
			for (int n = 1000; n < 10000; n++) {
				if (i == n + (n % 10) + ((n % 100) / 10) + ((n % 1000) / 100) + (n / 1000)) {
					selfNumber[i] = 0;
				}
			}
		}
		for (int n : selfNumber) {
			if (n != 0) {
				System.out.println(n);
			}
		}
	}

}
