import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 미친 풀이법 
public class BOJ_2493_arrVer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Tower[] stack = new Tower[N];
		int top =0;
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) { // 1~n타워까지 순차적 입장 
			Tower now = new Tower(i, Integer.parseInt(st.nextToken()));
			
			// 스택에 (나보다 왼쪽에 있던) 작은 놈들은 다 치워!!!!!! 계속 치워!!! 그러면 나는 비거나 큰놈일 때 반복 종료
			while(top > 0 && stack[top -1].height < now.height)
				top --; // 
			
			if(top == 0) // 결국 다 쪼꼬미 들이였네 
				sb.append("0 ");
			else
				sb.append(stack[top -1].num+ " ");
			
			stack[top] = now; //나도 후보가 되서 스택에 들어가자
			top ++;
		}
		System.out.println(sb.toString());
	}
	
	static class Tower{
		int num, height;

		public Tower(int num, int height) {
			this.num = num;
			this.height = height;
		}
	}

}
