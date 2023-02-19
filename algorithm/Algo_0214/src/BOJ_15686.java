import java.util.*;

public class BOJ_15686 {

	static int n, m;
	static int[][] board;
	static int min = Integer.MAX_VALUE;
	static ArrayList<Node> chickenList = new ArrayList<>(); // 치킨집 위치를 저장하는 리스트
	static ArrayList<Node> houseList = new ArrayList<>(); // 집의 위치를 저장하는 리스트
	static boolean[] chickenVisited; // 뽑은 치킨집 체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 1)
					houseList.add(new Node(i, j));
				else if (board[i][j] == 2)
					chickenList.add(new Node(i, j));
			}
		}

		chickenVisited = new boolean[chickenList.size()];
		chickentracking(0, 0);
		System.out.println(min);
	}

	public static void chickentracking(int count, int idx) {
		if (count == m) { 
			int total = 0; 
			for (int i = 0; i < houseList.size(); i++) {
				int sum = Integer.MAX_VALUE;
				for (int j = 0; j < chickenList.size(); j++) {
					if (chickenVisited[j] == true) { // i번째 집에서부터 j번짜 치킨집 까지의 거리 중 최소값을 구한다.
						int dist = Math.abs(houseList.get(i).x - chickenList.get(j).x)
								+ Math.abs(houseList.get(i).y - chickenList.get(j).y);
						sum = Math.min(sum, dist);
					}
				}
				total += sum;
			}
			min = Math.min(total, min);
			return;
		}

		for (int i = idx; i < chickenList.size(); i++) {
			if (chickenVisited[i] == false) {
				chickenVisited[i] = true;
				chickentracking(count + 1, i + 1);
				chickenVisited[i] = false;
			}
		}
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}