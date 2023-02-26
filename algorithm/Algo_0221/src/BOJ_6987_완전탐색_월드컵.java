import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6987_완전탐색_월드컵 {
	static int win[],lose[],draw[],team1[],team2[];
	static boolean flag;
	static int cnt_move;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		team1 = new int[15];		
		team2 = new int[15];
		// 나올 수 있느 총 가지수를 만들어보기 
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<6;j++) {
				team1[cnt]=i;
				team2[cnt++]=j;
			}
		} // 완탐 조건 맞춰주기 
	//	System.out.println(Arrays.toString(team1));
		//System.out.println(Arrays.toString(team2));
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			win = new int[6];		
			lose = new int[6];		
			draw = new int[6];	
			flag=false;			
			int w=0,l=0,d=0;
			for(int j=0;j<6;j++) {
				w += win[j] = Integer.parseInt(st.nextToken());
				d += draw[j] = Integer.parseInt(st.nextToken());
				l += lose[j] = Integer.parseInt(st.nextToken());
			}
			if(w+d+l!=30)
				flag=false;
			// 30이 안되면 캇뜨
			
			else
				OkOrNo(0);
			
			if(flag) System.out.print(1+" ");
			else System.out.print(0+" ");
			
			//System.out.println(cnt_move);
		}
	}
	static void OkOrNo(int idx) {
		cnt_move++;
		if(flag) return;
		if(idx==15) {
			flag=true;
			return;
		}
		int a = team1[idx];
		int b= team2[idx];
		//a가 이기는 경우
		if(win[a]>0 && lose[b]>0) {
			win[a]--;
			lose[b]--;
			OkOrNo(idx+1);
			win[a]++;
			lose[b]++;
		}
		//a와 b가 비기는 경우
		if(draw[a]>0 && draw[b]>0) {
			draw[a]--;
			draw[b]--;
			OkOrNo(idx+1);
			draw[a]++;                      
			draw[b]++;
		}
		//a가 지는 경우
		if(lose[a]>0 && win[b]>0) {
			lose[a]--;
			win[b]--;
			OkOrNo(idx+1);
			lose[a]++;
			win[b]++;
		}
	}
}