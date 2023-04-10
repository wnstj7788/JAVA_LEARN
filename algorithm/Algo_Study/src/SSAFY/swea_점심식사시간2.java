package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea_점심식사시간2 {

	static int N;
	static final int M = 1, W = 2, D = 3, C = 4; // 이동중, 대기, 내려가는 중, 완료
	static int cnt;
	static int answer;

	static class Person implements Comparable<Person> {
		int r, c, arrivalTime, downCnt, status;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}

		

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}

	}

	static List<Person> pList;
	static int[][] sList;
	static int[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<>(); // 사람리스트
			sList = new int[2][]; // 계단리스트
			answer = Integer.MAX_VALUE;

			for (int i = 0, k = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if (c == 1) {
						pList.add(new Person(i, j));
					} else if (c > 1) {
						sList[k++] = new int[] { i, j, c };
					}
				}
			}

			cnt = pList.size();
			selected = new int[cnt]; // 선택한 계단 인덱스
			// 모든 사람에게 계단 배정
			divide(0);

			System.out.printf("#%d %d\n", t, answer);
		}
	}

	static void divide(int index) {

		if (index == cnt) {
			int res = go();
			answer = answer > res ? res : answer;
			return;
		}

		// 계단0 선택
		selected[index] = 0;
		divide(index + 1);

		// 계단1 선택
		selected[index] = 1;
		divide(index + 1);
	}

	// 선택된 계단에 따라 사람들의 리스트 만들고 내려가기 처리후 소요된 시간 리턴
	static int go() {
		List<Person>[] list = new ArrayList[] { new ArrayList<>(), new ArrayList<>() };

		for (int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
		
			int no = selected[i];
			p.arrivalTime = Math.abs(p.r - sList[no][0]) + Math.abs(p.c - sList[no][1]);
			list[no].add(p);
		}

		int timeA = 0, timeB = 0;

		if (list[0].size() > 0) {
			timeA = processDown(list[0], sList[0][2]);
		}
		if (list[1].size() > 0) {
			timeB = processDown(list[1], sList[1][2]);
		}

		return timeA > timeB ? timeA : timeB;

	}

	static int processDown(List<Person> list, int height) {

		Collections.sort(list);

		int size = list.size() + 3;
		int[] D = new int[size];
		
		for (int i = 3; i < size; i++) {
			Person p = list.get(i-3);
			if(D[i-3]<= p.arrivalTime + 1) {
				// 내려갈 수 있는 상황 
				D[i] = p.arrivalTime +1 + height;// 도착시간 + 대시시간 + 계단 높이 
			}else {
				// 아직 내려가는 중 이라면 
				D[i] = D[i - 3] + height;
			}
		}

		return D[size -1];

	}

}