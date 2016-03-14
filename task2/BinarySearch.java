import java.io.*;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) throws Exception {
		int n, x;
		int a[];
		if (args.length > 0) {
			x = Integer.parseInt(args[0]);
			n = args.length - 1;
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(args[i + 1]);
			}
		} else {
			n = 10;
			x = 3;
			a = new int[10];
			for (int i = 0; i < 10; i++) {
				a[i] = 10 - i;
			}
		}
		System.out.println(binSearch(x, a, n));
//		System.out.println(binSearchRecur(x, a, -1, n - 1));
	}

	// Pre: n > 0
	// Post: 0 <= answer <= n && (answer == n - if there are not any a[answer] <= x in array)
	//                           or (a[anwer] - first element: a[answer] <= x)
	public static int binSearch(int x, int a[]) {
		if (n == 0) {
			return 0;
		}
		int l = -1, r = a.length - 1;
		while (l < r - 1) {
			int m = (l + r) / 2;
			if (a[m] > x) {
				l = m;
			} else {
				r = m;
			}
		}
		return (a[r] <= x) ? r : n;
	}

	// Pre: l < r && l = startIndex - 1, r = finishIndex - 1 && l >= -1 && r < n
	// Post: 0 <= answer <= n && (answer == n - if there are not any a[answer] <= x in array)
	//                           or (a[anwer] - first element: a[answer] <= x)
	public static int binSearchRecur(int x, int a[], int l, int r) {
		if (r == l) {
			return 0;
		}
		if (l == r - 1) {
			return (a[r] <= x) ? r : a.length;
		}
		int m = (l + r) / 2;
		if (a[m] > x) {
			return binSearchRecur(x, a, m, r);
		} else {
			return binSearchRecur(x, a, l, m);
		}
	}
}
