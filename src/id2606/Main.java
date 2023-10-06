package id2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int con = Integer.parseInt(br.readLine());
		String[] arr = new String[con];
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[n + 1];
		for (int i = 0; i < con; i++) {
			arr[i] = br.readLine();
		}
		queue.add(1);
		visited[1] = 1;
		int virused = 0;
		while (queue.isEmpty() == false) {
			int p = queue.poll();
			for (int i = 0; i < con; i++) {
				if (arr[i].contains(p + "")) {
					String[] pair = arr[i].split(" ");
					int a = Integer.parseInt(pair[0]);
					int b = Integer.parseInt(pair[1]);
					if (b == p && visited[a] == 0) {
						queue.add(a);
						visited[a] = 1;
						arr[i] = "";
						virused++;
					} else if (a == p && visited[b] == 0) {
						queue.add(b);
						visited[b] = 1;
						arr[i] = "";
						virused++;
					}
				}
			}
		}
		bw.write(virused + "");
		bw.flush();
		bw.close();

	}

}
