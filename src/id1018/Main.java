package id1018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] leftTopBlack = new int[m][n];
		int[][] leftTopWhite = new int[m][n];
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i % 2 == j % 2) {
					if (arr[i].charAt(j) == 'B') {
						leftTopWhite[j][i]++;
					} else {
						leftTopBlack[j][i]++;
					}
				} else {
					if (arr[i].charAt(j) == 'W') {
						leftTopWhite[j][i]++;
					} else {
						leftTopBlack[j][i]++;
					}
				}
			}
		}

		int smallest = 32;
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				int whiteSum = 0;
				int blackSum = 0;
				for (int a = 0; a < 8; a++) {
					for (int b = 0; b < 8; b++) {
						whiteSum += leftTopWhite[j + b][i + a];
						blackSum += leftTopBlack[j + b][i + a];
					}
				}
				if (whiteSum < smallest) {
					smallest = whiteSum;
				}
				if (blackSum < smallest) {
					smallest = blackSum;
				}
			}
		}

		bw.write(smallest + "");
		bw.flush();
		bw.close();
	}

}
