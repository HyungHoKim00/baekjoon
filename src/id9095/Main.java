package id9095;

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
		int[] a = new int[n];
		int biggest = 5;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			if (a[i] > biggest) {
				biggest = a[i];
			}
		}
		int[] ck = new int[biggest + 1];
		ck[1] = 1;
		ck[2] = 2;
		ck[3] = 4;
		ck[4] = 7;
		for (int i = 5; i < biggest + 1; i++) {
			ck[i] = ck[i - 3] + ck[i - 2] + ck[i - 1];
		}
		for (int i = 0; i < n; i++) {
			bw.write(ck[a[i]] + "\n");
			bw.flush();
		}
		bw.close();
	}

}

