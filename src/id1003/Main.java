package id1003;

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
		int biggest = 2;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			if (a[i] > biggest) {
				biggest = a[i];
			}
		}
		int[] cZero = new int[biggest + 1];
		int[] cOne = new int[biggest + 1];
		cZero[0] = 1;
		cZero[1] = 0;
		cOne[0] = 0;
		cOne[1] = 1;
		for (int i = 2; i < biggest + 1; i++) {
			cZero[i] = cZero[i - 1] + cZero[i - 2];
			cOne[i] = cOne[i - 1] + cOne[i - 2];
		}
		for (int i = 0; i < n; i++) {
			bw.write(cZero[a[i]] + " " + cOne[a[i]] + "\n");
			bw.flush();
		}
		bw.close();
	}

}
