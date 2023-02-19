import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1210 {
	public static int start_i;
	public static int start_j;

	public static void main(String[] args) throws IOException {
		// 스캐너로하면 시간 초과....
		// Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int TC = sc.nextInt();

		// 100* 100 사다리에서 경품을 찾으려면 어디서 출발해야하는가?
		// 경품의 위치를 모르는 상태로 전부 돌리면 비율적
		// 경품이 있는 위치에서 올라온다면 1가지 경우만 고려하면 될 것 같다

		int dx[] = { 0, -1, 0 }; // 아래에서 위로 올라오기 때문에 y좌표가 -1 되는 경우만 존재 100째칸에서 1칸까지 가야하기 때문
		int dy[] = { -1, 0, 1 }; // 좌 우로 이동해야하기 때문에 -1 , 1 선언

		for (int T = 0; T < 10; T++) { // 태스트 케이스 시작
//			sb.append("#").append(br.readLine()).append(" ");
			int TC = Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];
			for (int i = 0; i < 100; i++) {// 100 * 100의 입력
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) { // 100번쨰 줄에서 경품이 있는 위치를 확인 = 시작위치 선정
						start_i = i;
						start_j = j; // 99번쨰 줄 부터 올라가기
					}
				}
			} // 입력

			// 3방 탐색 시작 = arr[start_i -1 ][start_j]
			// 조건: 좌,우로 움직일 수 있다면 먼저 움직이기 , 좌우로 움직 일 수 없다면 위로 올라가기
			// arr[0][?] = 1번째 행이 될때까지 반복
			while (start_i != 0) {

				for (int i = 0; i < 3; i++) { // 3방탐색 시
					int di = start_i + dx[i];
					int dj = start_j + dy[i];

					if (di >= 0 && di < 100 && dj >= 0 && dj < 100 && arr[di][dj] == 1) {// 100 & 100에 있고 이미 방문한 적이 없다면!
						arr[start_i][start_j] = 3; // 방문처리
						start_i = di;
						start_j = dj;

					}
				} // 3방 검색 끝
			}

			//sb.append(start_j).append("\n");
			System.out.println("#" + TC + " " + start_j);

		} // 테케 끝

	}

}
