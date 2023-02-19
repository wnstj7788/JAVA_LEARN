import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_14888 {
	public static int N;
	public static int arr[];
	public static String Operator_char[];
	public static String result[];
	public static  boolean visited[];
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new int[N];
		Operator_char = new String[N - 1];
		result = new String[N - 1];
		visited = new boolean[N-1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int Operator[] = new int[4];

		for (int i = 0; i < Operator.length; i++) {
			Operator[i] = sc.nextInt();
		}
		int cnt = 0;                                   
		for (int i = 0; i < Operator.length; i++) {
			if (i == 0) {
				for (int j = 0; j < Operator[i]; j++) {
					Operator_char[cnt] = "+";
					cnt++;

				}
			} else if (i == 1) {
				for (int j = 0; j < Operator[i]; j++) {
					Operator_char[cnt] = "-";
					cnt++;
				}
			} else if (i == 2) {
				for (int j = 0; j < Operator[i]; j++) {
					Operator_char[cnt] = "*";
					cnt++;
				}
			} else {
				for (int j = 0; j < Operator[i]; j++) {
					Operator_char[cnt] = "/";
					cnt++;
				}
			}

		}
		perm(0);
		System.out.println(max);
		System.out.println(min);

		// for(char ch : Operator_char ) System.out.println(ch +" ");
	}

	static void perm(int idx) {
	
		if (idx == N - 1) {
			
			int num = arr[0];
			
			for(int i = 0; i < N-1; i++ ) {
				if(result[i].equals("+")) {
					num += arr[i+1];
				}else if(result[i].equals("-")) {
					num -= arr[i+1];
				}else if(result[i].equals("*")) {
					num *= arr[i+1];
				}else if(result[i].equals("/")) {
					num /= arr[i+1];
				}
				
			}
			
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}

		for (int i = 0; i < Operator_char.length; i++) {
			if(visited[i]) continue;
			// System.out.println("dighghghghghgh");
			// System.out.println(Operator_char[i]);
			result[idx] = Operator_char[i];
			visited[i] = true;
			perm(idx + 1); // 시작점을 미뤄버려서 한번 같던 요소는 다시 접근하지 않음을 이용
			
			visited[i] = false;
		}
	}
	
	
	
    
	
	
}
