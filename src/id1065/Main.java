package id1065;

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
		int m = 0;
		if (n <= 99) {
			m = n;
		} else {
			m = 99;
			for (int i = 100; i <= n; i++) {
				if (i / 100 - (i / 10 - (i / 100) * 10) == (i / 10 - (i / 100) * 10) - i % 10) {
					m++;
				}
			}
		}
		bw.write(m + "");
		bw.flush();
		bw.close();

	}

}
