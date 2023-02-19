import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreedyTest {
	// 원소 스스로가 나랑 다른 원소랑 스스로 비교
	private static class Meeting implements Comparable<Meeting> { // 타입임을 명시
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		// Meeting 타입의 배열을 만들거임
		// 정렬을 위해 우리가 알려줘야하는 것이 기준

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			// 나의 종료시간과 상대의 종료시간을 비교할거임
			// 오름 차순 정렬
			// 음수가 나오면? -> 상대의 종료시간이 크면 그대로 둠 ex) 10 - 11 => 10 ,11
			// 양수가 나오면 11 , 10 = 10,11 -> 교환
			return this.end != o.end ? this.end - o.end : this.start - o.start;
			// 조건이 맞다면 앞의 결과를 출력하고 아니면 뒤의 결과를 줌
			// 종료시간이 빠른 순 결과를 원하기 때문에 종료시간 순으로 오름차순 결과를 원함
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		// 회의 개수

		Meeting[] m = new Meeting[cnt];

		for (int i = 0; i < cnt; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(m);

		List<Meeting> result = new ArrayList<Meeting>();

		result.add(m[0]); // 첫 회의 무적권 넣고 시작

		for (int i = 1; i < cnt; i++) {
			// 마지막 회의의 종료 시간보다 현재 회의의 시작 시간이 같거나 크다면 양립 가능
			if (result.get(result.size() - 1).end <= m[i].start) {
				result.add(m[i]);// 현재회의에 넣어줌
			}
		}

		System.out.println(result.size());

		for (Meeting meeting : result) {
			System.out.println(meeting);
		}

	}
}
