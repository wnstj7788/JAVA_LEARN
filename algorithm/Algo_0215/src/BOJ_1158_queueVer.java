import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_queueVer {
	public static void main(String[] args) {
		// queue를 이용하기 
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int K =sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();// 큐는 인터페이스
		
		for (int i = 1; i <= N; i++) 
			queue.add(i);
			
		StringBuilder sb = new StringBuilder("<");
			
		int cnt =0;
			
			while(!queue.isEmpty()) {
				int now = queue.poll(); // 한놈 나와!
				cnt++;
				if(cnt == K) {
					sb.append(now+ ", ");
					cnt = 0;
					
				}else {
					queue.add(now);
				}
			}
		
		
		sb.delete(sb.length()-2, sb.length()); // 이건 알아가자 
		sb.append(">");
		System.out.println(sb.toString());
		}
	}


