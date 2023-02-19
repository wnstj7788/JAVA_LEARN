import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10;
		for(int t = 1; t <= TC ; t ++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int tc = sc.nextInt();
			
			int idx  =1;
			
			for(int i = 0 ; i < 8 ; i ++) {
				queue.offer(sc.nextInt());
			}
			
			while(true) {
				if(idx == 6) {
					idx = 1;
				}
				int a = queue.poll() - idx;
				if (a <= 0) {
					queue.offer(0);
					break;
				}else 
					queue.offer(a);
				idx++;
			}
			
			System.out.print("#" + tc +" ");
			while(!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
				
			
		}
	}
	

}
