package id11726;

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
		if (n == 1) {
			bw.write("1");
		} else if (n == 2) {
			bw.write("2");
		} else {
			arr[1] = 1;
			arr[2] = 2;
			for (int i = 3; i < n + 1; i++) {
				arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
			}
			bw.write(arr[n] + "");
		}
		bw.flush();
		bw.close();
	}

}
