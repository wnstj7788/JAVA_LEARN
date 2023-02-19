package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N + 1];
		
		arr[0] = 0; 
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i ++) {
			arr[i] = arr[i -1] +  Integer.parseInt(st1.nextToken());  // 값을 더해가며 값을 저장함 
		}
		
		//System.out.println(Arrays.toString(arr));
		
		
		for(int i = 0; i < M; i ++ ) {
			int sum = 0;
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int fir = Integer.parseInt(st2.nextToken());
			int next = Integer.parseInt(st2.nextToken());
			//System.out.println(fir + " " + next);
//			for(int j = fir; j <= next ; j++) { // 수정 
//				sum += arr[j -1];
//			}
			//arr[next] = arr[next-1] + arr[next - fir];
			//System.out.println(arr[next]-arr[fir-1]);
			
			System.out.println(arr[next] - arr[fir-1]); // 이미 계산 된 배열에서 처음과 끝을 빼서 결과 도출  
		}
		
	}
}
