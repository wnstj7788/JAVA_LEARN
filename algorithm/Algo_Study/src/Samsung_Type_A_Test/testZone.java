package Samsung_Type_A_Test;

import java.util.Arrays;
import java.util.Scanner;

public class testZone {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int map[][] = new int[N][N];
		int temp[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				map[i][j] = sc.nextInt();
				
			}
		}		
		
		
		temp = map;
		
		System.out.println("map");
		System.out.println(Arrays.deepToString(map));
		System.out.println("temp");
		System.out.println(Arrays.deepToString(temp));
		
		int temp_a[][] = new int [N][N];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				temp_a[i][j] = temp[i][j];
				
			}
		}		
		
		System.out.println("temp");
		System.out.println(Arrays.deepToString(temp));
		System.out.println("temp_a");
		System.out.println(Arrays.deepToString(temp_a));
		
		
	}

}
