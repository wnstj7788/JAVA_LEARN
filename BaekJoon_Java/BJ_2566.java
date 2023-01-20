

import java.util.Scanner;

public class BJ_2566 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[][] = new int[9][9];
		int max = 0,max_i=0,max_j =0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (max <= arr[i][j]) {
					max = arr[i][j];
					max_i = i +1 ;
					max_j = j +1 ;
				}
			}
		}
		System.out.println(max);
		System.out.println(max_i +" "+max_j);

	}

}
