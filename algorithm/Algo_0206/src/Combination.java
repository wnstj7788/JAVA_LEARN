import java.util.Scanner;

public class Combination {
	
	public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
		if(depth == r) {
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) System.out.print(arr[i] + " ");  // 방문처리 되어있는 수만 출력
			}
			System.out.println();
			return;
		}
	

		for (int i = start; i < arr.length; i++) {    // start점 부터 시작
			if(!visited[i]) {       // 방문처리 안되어 있으면
				visited[i] = true;    // 방문처리
				combination(arr, visited, i + 1, depth + 1, r);  //start값을 1씩 증가시켜 중복 포함하지 않도록 함
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int [n+1];
		for(int i =0; i< n ;i++) {
			arr[i] = sc.nextInt();	
		}

		
		int r = sc.nextInt();

		boolean[] visited = new boolean[arr.length];
		
		combination(arr, visited, 0, 0, r);
	}
}