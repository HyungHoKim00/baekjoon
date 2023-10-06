package id2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		int[] arr = new int[a];
		for (int i = 0; i < a; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(arr);
		for (int i = 0; i < a; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
	}

	public static void mergeSort(int[] arr) {
		int a = arr.length / 2;
		int b = arr.length - a;
		if (arr.length > 1) {
			int[] u = new int[a];
			for (int i = 0; i < a; i++) {
				u[i] = arr[i];
			}
			int[] v = new int[b];
			for (int i = 0; i < b; i++) {
				v[i] = arr[i + a];
			}
			mergeSort(u);
			mergeSort(v);
			merge(arr, u, v, a, b);
		}
	}

	public static void merge(int[] arr, int[] u, int[] v, int a, int b) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < a && j < b) {
			if (u[i] < v[j]) {
				arr[k] = u[i];
				i++;
			} else {
				arr[k] = v[j];
				j++;
			}
			k++;
		}
		if (i >= a) {
			while (j < b) {
				arr[k] = v[j];
				j++;
				k++;
			}
		} else {
			while (i < a) {
				arr[k] = u[i];
				i++;
				k++;
			}
		}
	}

}
