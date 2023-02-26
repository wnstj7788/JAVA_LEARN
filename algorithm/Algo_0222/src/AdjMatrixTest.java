import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {

	static int[][] AdjMatrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		AdjMatrix = new int[V][V]; // 모두 0으로 초기화된 상태

		int from, to;
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			
			AdjMatrix[to][from] = AdjMatrix[from][to] = 1; // 무향 그래프인 경우
		}
		print();

	}
	
	
	static void print() {
		for(int[] am : AdjMatrix) {
			System.out.println(Arrays.toString(am));
		}
	}

}
