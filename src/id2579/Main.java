package id2579;

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
		int[] arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if (n == 1) {
			bw.write(arr[1] + "");
		} else if (n == 2) {
			bw.write(arr[2] + arr[1] + "");
		} else {
			int[] point = new int[n + 1];
			point[0] = 0;
			point[1] = arr[1];
			point[2] = arr[2] + arr[1];
			for (int i = 3; i < n + 1; i++) {
				point[i] = Math.max(arr[i - 1] + point[i - 3], point[i - 2]) + arr[i];
			}
			bw.write(point[n] + "");
		}
		bw.flush();
		bw.close();


	}

}
