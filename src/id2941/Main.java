package id2941;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int aNumber = s.length();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '=') {
				if (s.charAt(i - 1) == 'c' || s.charAt(i - 1) == 's' || s.charAt(i - 1) == 'z') {
					if (i > 1 && s.charAt(i - 1) == 'z' && s.charAt(i - 2) == 'd') {
						aNumber -= 2;
					} else {
						aNumber -= 1;
					}
				}
			} else if (s.charAt(i) == '-') {
				if (s.charAt(i - 1) == 'c' || s.charAt(i - 1) == 'd') {
					aNumber -= 1;
				}
			} else if (s.charAt(i) == 'j') {
				if (s.charAt(i - 1) == 'l' || s.charAt(i - 1) == 'n') {
					aNumber -= 1;
				}
			}
		}
		System.out.println(aNumber);
	}

}
