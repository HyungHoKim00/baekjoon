package id9012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}
		for (int i = 0; i < n; i++) {
			if (s[i].length() % 2 == 0 && s[i].startsWith("(") && s[i].endsWith(")")) {
				Stack<Integer> stack = new Stack<>();
				int l = s[i].length();
				boolean tf = true;
				for (int j = 0; j < l; j++) {
					if (s[i].charAt(j) == '(') {
						stack.push(1);
					} else {
						if (stack.isEmpty() != true) {
							stack.pop();
						} else {
							tf = false;
							break;
						}
					}
				}
				if (stack.isEmpty() == true && tf == true) {
					bw.write("YES");
				} else {
					bw.write("NO");
				}
			}else {
				bw.write("NO");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
