package id1929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] arr = new int[b + 1];
		if (b == 1) {
		} else if (b == 2) {
			bw.write("2");
			bw.flush();
		} else if (b == 3) {
			if (a == 3) {
				bw.write("3");
				bw.flush();
			} else {
				bw.write("2\n3");
				bw.flush();
			}
		} else {
			arr[2] = 1;
			arr[3] = 1;
			for (int i = 4; i <= b; i++) {
				for (int j = 2; j < Math.sqrt(i) + 1; j++) {
					if (arr[j] == 1 && i % j == 0) {
						arr[i] = 0;
						break;
					}
					arr[i] = 1;
				}
			}
			for (int i = a; i <= b; i++) {
				if (arr[i] == 1) {
					bw.write(i + "\n");
					bw.flush();
				}
			}
		}
		bw.close();
	}

}
