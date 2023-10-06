package id10828;

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
		String[] order = new String[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			order[i] = br.readLine();
		}
		for (int i = 0; i < n; i++) {
			if (order[i].equals("pop")) {
				if (stack.isEmpty()) {
					bw.write("-1");
				} else {
					bw.write(stack.pop() + "");
				}
				bw.write("\n");
				bw.flush();
			} else if (order[i].equals("size")) {
				bw.write(stack.size() + "");
				bw.write("\n");
				bw.flush();
			} else if (order[i].equals("empty")) {
				if (stack.isEmpty()) {
					bw.write("1");
				} else {
					bw.write("0");
				}
				bw.write("\n");
				bw.flush();
			} else if (order[i].equals("top")) {
				if (stack.isEmpty()) {
					bw.write("-1");
				} else {
					bw.write(stack.peek() + "");
				}
				bw.write("\n");
				bw.flush();
			} else {
				String arr[] = order[i].split(" ");
				stack.push(Integer.parseInt(arr[1]));
			}
		}
		bw.close();
	}

}
