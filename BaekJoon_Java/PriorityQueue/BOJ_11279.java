package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11279 {
	static class compare implements Comparable<compare>{
		 int x,y;
		 
		 public compare(int x, int y){ //일반 값 절대 값 저장 
			 this.x = x;
			 this.y = y;
		 }

		@Override
		public int compareTo(compare o) {
			if(this.y == o.y)
				return this.x - o.x; 
			return this.y - o.y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<compare> pr = new PriorityQueue<>();
		int map[] = new int[n];
		
		for(int i = 0; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num ==0 ) {// 들어오는 값이 0이라면 아래의 연산 시
				if(!pr.isEmpty()) // 큐가 비어있지 않다면 
					System.out.println(pr.poll().x);
				else //큐가 비어있다면 
					System.out.println(0);
			}else {
				pr.add(new compare(num, Math.abs(num))); //절대값으로 만들어서 추가하기 
			}
		}
		
	}
	

}
