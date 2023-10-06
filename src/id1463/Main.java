package id1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		forCounting c = new forCounting(n);
		bw.write(c.makeOne() + "");
		bw.flush();
		bw.close();
	}

}

class forCounting {
	private int n;
	private int[] arr;

	forCounting(int n) {
		this.n = n;
		arr = new int[n + 1];
	}

	public int makeOne() {
		if (n == 1) {
			return 0;
		} else if (n == 2 || n == 3) {
			return 1;
		} else {
			arr[1] = 0;
			arr[2] = 1;
			arr[3] = 1;
			for (int i = 4; i < n + 1; i++) {
				if (i % 6 == 0) {
					arr[i] = Math.min(arr[i / 3], arr[i / 2]) + 1;
				} else if (i % 3 == 0) {
					arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1;
				} else if (i % 2 == 0) {
					arr[i] = Math.min(arr[i / 2], arr[i - 1]) + 1;
				} else {
					arr[i] = arr[i - 1] + 1;
				}
			}
			return arr[n];
		}

	}

}