import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406 {
	static int [][] map; // 진짜 배열
	static int [][] temp; // 임시 배열 
	static boolean [] isSelected;// 회전 순서를 순열로 표현하기 위한 존재 
	static String [] rotateInput; 
	static String [] rotateInput_result; 
	static int N, M , R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
	//원본배열 회손 시키지 않음
		temp = new int[N][M]; 
		rotateInput = new String[R];
		rotateInput_result = new String[R];
		isSelected = new boolean[R];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			rotateInput[i] = br.readLine();
			
		}
		
		
		permutation(0);
		
		
	}
	
	
	
	public static void rotate(int r, int c, int s) {//오른쪽으로 90도 회전
	
		int idx = r+s;
		
		for(int i=r-s -1  ; i<c ; i++) {
			for(int j= c-s-1 ; j<c+s-1; j++) {
				temp[j -1 ][idx] = map[i][j];
			}
			idx--;
		}
	}
	
	private static void permutation(int cnt) {

		if (cnt == R) {
			temp = new int[N][M]; 
			System.out.println(Arrays.toString(rotateInput_result));
			int r = Integer.parseInt(rotateInput_result[0].substring(0,1));
			int c = Integer.parseInt(rotateInput_result[0].substring(2,3));
			int s = Integer.parseInt(rotateInput_result[0].substring(4,5));
			System.out.println(r +" "+c+" "+s);
			
			rotate(r,c,s);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
//					if(temp[i][j] == 0) {
//						temp[i][j] =map[i][j];
//					}
					
					System.out.print(temp[i][j] + " ");
				}
				System.out.println();
			}
			
			
			return;
		}

		for (int i = 0; i < R; i++) {
			if (isSelected[i])
				continue;

			rotateInput_result[cnt] = rotateInput[i];
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
