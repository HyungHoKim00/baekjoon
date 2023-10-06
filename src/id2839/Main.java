package id2839;

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
		int j = -1;
		switch (n % 5) {
		case 0:
			if (n >= 5) {
				j = n / 5;
			}
			break;
		case 1:
			if (n >= 6) {
				j = (n - 6) / 5 + 2;
			}
			break;
		case 2:
			if (n >= 12) {
				j = (n - 12) / 5 + 4;
			}
			break;
		case 3:
			if (n >= 3) {
				j = (n - 3) / 5 + 1;
			}
			break;
		case 4:
			if (n >= 9) {
				j = (n - 9) / 5 + 3;
			}
			break;
		default:
			break;
		}
		bw.write(j + ""); // 문자열로 형태 변환
		bw.flush();
		bw.close();
	}

}
