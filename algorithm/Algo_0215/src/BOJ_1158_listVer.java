import java.util.ArrayList;
import java.util.Scanner;



public class BOJ_1158_listVer {
	public static void main(String[] args) {
		// queue를 이용하기
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		//LinkedList시간 초과난다잉 ㅋ_ㅋㅋ_ㅋ_ㅋ_ㅋ_ㅋ_ㅋ__ㅋㅋ_ㅋ_ㅋ_
		ArrayList<Integer> list = new ArrayList<>();// 큐는 인터페이스

		for (int i = 1; i <= N; i++)
			list.add(i);

		StringBuilder sb = new StringBuilder("<");

		int cnt = 0, idx = 0;

		while (list.size() > 0) {
			int now = list.get(idx); 
			cnt++; //123123123`123123123123
			if (cnt == K) {
				list.remove(idx);
				sb.append(now + ", ");
				cnt = 0;
				idx--; //방금 인덱스 죽였으니까 뒤에 인덱스가 인덱스로 딸려오니까 인덱스 자리 다시 확인이 필요헹 
			} 
			idx ++; //0,1,2,3,4,5,6, 0,1,2,3,4,5
			if(list.size() == 0) break;
			idx = idx % list.size(); // 인덱스 조절 미쳤다!
			
		}

		sb.delete(sb.length() - 2, sb.length()); // 이건 알아가자
		sb.append(">");
		System.out.println(sb.toString());
	}
}
