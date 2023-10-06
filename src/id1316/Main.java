package id1316;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int ans = 0;
		for (int i = 0; i < a; i++) {
			String s = in.next();
			int l = s.length();
			if (l < 3) {
				ans++;
			} else {
				char chars[] = s.toCharArray();
				boolean b = true;
				for (int j = 2; j < l; j++) {
					for (int k = 2; k <= j; k++) {
						if (chars[j - k] == chars[j] && chars[j - 1] != chars[j]) {
							b = false;
						}
					}
				}
				if (b == true) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}


