package again;

import java.util.Scanner;

public class BOJ_17406_배열돌리기교수님버전 {
	static int N, M,K;
	static int [][] map;
	
	
	static Rotate[] cards; // 입력으로 들어오는 회전 연산 (순열의 재료)
	static Rotate[] result; //cards를 이용해 만든 순열이 저장되는 배열 
	static boolean[] used;
	
	static int ans = Integer.MAX_VALUE; // 최소값 저장할 변수
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		 
		map = new int[N+1][M+1]; // 인덱스 1부터 시작한다고 문제에 나와있으니 꼭 확인하기  이런거 적으면서 코딩하기 
		for(int i = 1; i <= N ; i++) {
			for(int j = 1; j <=M; j ++) {
				map[i][j] = sc.nextInt();
			}
		}
		cards = new Rotate[K];
		result = new Rotate[K];
		used = new boolean[K];
		
		for(int k = 0; k< K; k++) {
			cards[k] = new Rotate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
	
//		int [][] copy = deepcopy(map);
//		rotate(copy, cards[0]);
//		print(copy);
		
		
		perm(0);
		
		System.out.println(ans);
	
	}
	
	static void perm(int idx) {
		if(idx == result.length) { // result 배열이 다 채워졌네> 순열 완 , 하나 시뮬 고고
			
			
			int[][] copy = deepcopy(map);
			for(int i = 0; i < result.length; i++) {
				rotate(copy, result[i]);
			}
			
			for(int i =1; i<=N; i++) {
				int rowSum = 0;
				for(int j = 1; j <=M; j++) {
					rowSum += copy[i][j];
				}
				ans = Math.min(ans,rowSum);
			}
		}
		
		
		for(int i =0; i < cards.length; i++) {
			if(used[i]) continue;
			
			
			result[idx] = cards[i];
			used[i] = true;
			perm(idx +1);
			used[i] = false;
		}
	}
	
	
	static void print(int[][] origin) {
		for(int i = 0; i <origin.length; i++) {
			for (int j = 0; j < origin.length; j++) {
				System.out.print(origin[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}
	
	
	
	static class Rotate{
		int r,c,s;
		public Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
		@Override
		public String toString() {
			return "Rotate [r=" + r + ", c=" + c + ", s=" + s + "]";
		}

		
	}
	
	static int[][] deepcopy(int [][] origin){
		int[][] copy = new int[origin.length][origin[0].length];
		for(int i  = 0; i <origin.length; i++) {
			for(int j = 0; j <origin[0].length; j++) {
				copy[i][j] = origin[i][j];
			}
			
		}
		return copy;
	}
	
	
	static void rotate(int[][] copy, Rotate now) {
		for(int s =1; s <= now.s; s++) {
			int i = now.r-s, j=now.c-s;
			int temp = copy[i][j]; //현재 회전하는 구간 왼쪽위 한칸 뽑아놓기
			
			for( i = now.r-s; i< now.r+s; i++) {
				copy[i][j] = copy[i+1][j];
			}
			
			for(j = now.c -s; j < now.c+s; j++) {
				copy[i][j] = copy[i][j+1];
			}
			
			
			for(i= now.r +s; i > now.r-s; i--) {
				copy[i][j] = copy[i-1][j];
			}
			
			for(j = now.c + s; j > now.c-s; j--) {
				copy[i][j] = copy[i][j-1];
			}
			
			copy[now.r-s][now.c-s +1 ] = temp; //왼쪽 위에 있던 애는 시계 방향으로 그 오른쪽 칸에 넣어줌 
		}
		
	}
	
	
}
