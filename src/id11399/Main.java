package id11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] p = br.readLine().split(" ");
		int[] pp = new int[n];
		for (int i = 0; i < n; i++) {
			pp[i] = Integer.parseInt(p[i]);
		}
		Arrays.sort(pp);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += (n - i) * pp[i];
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}
