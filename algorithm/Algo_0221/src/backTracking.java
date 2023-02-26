import java.util.Arrays;
import java.util.Scanner;

public class backTracking {

	static int N, col[], answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// 놓아진 퀸의 정보를 관리해야함 // 같은행에는 두지 않을 것이당
		// 2차원 필요? ㄴㄴ 1차원으로 객체 만들어 넣자 ㅋㅋ_ㅋㅋ

		col = new int[N + 1];

		setQueen(1);
		System.out.println(answer);

	}

	private static void setQueen(int rowNo) { // rowNO: 놓으려고하는 퀸의 행 번호
		// System.out.println(Arrays.toString(col));
		if (!isAvailable(rowNo - 1))
			return;

		if (rowNo > N) {
			answer ++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			setQueen(rowNo + 1);

		}

	} 	
	

	private static boolean isAvailable(int rowNo) {
		// System.out.println(Arrays.toString(col));

		for (int k = 1; k < rowNo; k++) { // K 비교대산 queen번호
			if (col[k] == col[rowNo] || Math.abs(col[k] - col[rowNo]) == rowNo - k)
				return false;

		}

		return true;
	}

}
