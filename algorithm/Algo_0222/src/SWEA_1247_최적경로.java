import java.sql.Connection;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1247_최적경로 {
	static int N;
	static boolean isSelectd[];
	static int Nhome[];
	static int map[][];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int i = 1; i <= TC; i++) {
			N = sc.nextInt();
			isSelectd = new boolean[N + 2];
			Nhome = new int[N +2 ];
			map = new int[N + 2][2];
			map[0][0] = sc.nextInt(); // 회사
			map[0][1] = sc.nextInt(); // 집
			
			map[N + 1][0] = sc.nextInt();
			map[N + 1][1] = sc.nextInt();

			for (int j = 1; j <= N; j++) {
				map[j][0] = sc.nextInt();
				map[j][1] = sc.nextInt();
			}

			
			//System.out.println(Arrays.deepToString(map));

			perm(1);
			

			System.out.println("#" +i + " " +min);
			min = Integer.MAX_VALUE;
		} // tc end

	}// main end

	private static void perm(int idx) {
		if (idx == N + 1) {
			//System.out.println(Arrays.toString(Nhome));
			Nhome[0] = 0;
			isSelectd[0] =true;
			
			Nhome[N + 1] = N + 1;
			isSelectd[N + 1] = true;
			
			int sum = 0;
			for (int i = 0; i <= N ; i++) {
				sum += Math.abs(map[Nhome[i]][0] - map[Nhome[i + 1]][0]) + Math.abs(map[Nhome[i]][1] - map[Nhome[i + 1]][1]);
			}
			//System.out.println(sum);
			
			
			min = Math.min(sum, min);
			
			return ;
	
		}

		for (int j = 1; j <= N; j++) {
			if (isSelectd[j] == true)
				continue;
			isSelectd[j] = true;
			Nhome[idx] = j;
			perm(idx + 1);
			isSelectd[j] = false;

		}

	}

}
