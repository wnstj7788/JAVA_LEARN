import java.util.Arrays;
import java.util.Scanner;

public class test_서로소집합 {
	// 각자 전부 다 대장이라고 시작
	// 팀을 이룰 때 대장을 새로 선정함 -> union
	// 팀장은 index i랑 그 칸에 있는 disjoint[i]의 값이 일치
	// union(int n1, int n2) -> 둘다 팀장이 아님에 주의하자
	// p1 = find(n1);
	// p2 = find(n2); 팀장 찾기
	// disjoint[p1] = p2; 대표 바꾸기

	static int[] disjoint;
	static int N,M;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			cnt = 0;
			makeSet();
			for (int i = 0; i < M; i++) {
				union(sc.nextInt(), sc.nextInt());
			}
			
			for (int i = 1; i <= N; i++) {
				if(disjoint[i] == i)
					cnt++;
				
			}
			
			System.out.println("#" + tc + " "+ cnt);
			
		}
	}

	static void makeSet() {// 각각이 1인팀 
		disjoint = new int[N+1];
		for (int i = 1; i <= N; i++) {
			disjoint[i] = i;
		}
	}

	static int find(int i) { // 같으면 대표
		if (i == disjoint[i]) {
			return i;
		}else // 아니면 자기 상사한테 대표 어딨냐고 물어봄
			//재귀호출해놓고 기다리면 언젠가 대표번호 리턴옴, 그걸 내ㅔ 칸에 다이렉트로 대표 번호저장 \\ >_< //
			// 경로 압축
			return disjoint[i] = find(disjoint[i]);

	}

	static boolean union(int n1, int n2) {
		int p1 = find(n1);// n1이 소솓된 그룹의 대표를 일단 찾아라(말단끼리 합병 못 함)
		int p2 = find(n2);
		//이미 같은 대표 소속 
		if(p1 == p2)
			return false;
		disjoint[p1] = p2; // p1 대표직 p2한테 내줌
		return true;

	}

}
