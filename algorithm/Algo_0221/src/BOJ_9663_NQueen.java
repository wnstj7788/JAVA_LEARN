import java.util.Scanner;

public class BOJ_9663_NQueen {
	static boolean QueenMove[][];
	static int N;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		QueenMove = new boolean[N][N];
		
		setQueen(1);
		
	}

	private static void setQueen(int rowNo) {
		if (!isAvailable(rowNo - 1))
			return;

		if (rowNo > N) {
			answer ++;
			return;
		}

		for (int i = 1; i <= N; i++) {

		}
		
	}

	private static boolean isAvailable(int i) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
