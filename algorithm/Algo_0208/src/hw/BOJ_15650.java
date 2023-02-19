package hw;

import java.util.Scanner;

public class BOJ_15650 {

	public static int[] arr;
	public static int N, M;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		M = in.nextInt();

		arr = new int[M];

		comb(1, 0);

	}

	public static void comb(int at, int start) {

		if (start == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}

		for (int i = at; i <= N; i++) {

			arr[start] = i;
			comb(i + 1, start + 1);

		}

	}
}