import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_버전_1 {

    static int N;
    static int K;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();


        System.out.println(bfs());
        

    }
    
    private static int bfs(){
    	
    	Queue<Point> q = new LinkedList<>();
    	boolean[] visit = new boolean[100001];
    	
    	q.add(new Point(N,0)); // 출발점은 연산횟수 없이 그냥 만들어진 수임
    	
    	visit[N] = true; // 큐에 넣을 때 표기하기 
    	
    	
    	while (!q.isEmpty()){ // 방문 스케쥴이 남은게 있으면 계쏙하자
    		Point now = q.poll();
    		
    		if(now.num ==K) {
    			return now.cnt; //now.num이 되기까지 연산을 면ㅊ번 수행했느가?> 그게 답이다 
    		}
    		
    		if(now.num + 1 <= 100000 && !visit[now.num +1]) { // +1연상를 수행해서 만들 수 있는 인접 행렬 
    			q.add(new Point(now.num+1, now.cnt +1));
    			visit[now.num+1] = true;
    		}
    		
    		if(now.num - 1 >= 0 && !visit[now.num -1]) { // -1연상를 수행해서 만들 수 있는 인접 행렬 
    			q.add(new Point(now.num-1, now.cnt +1));
    			visit[now.num-1] = true;
    		}
    		
    		if(now.num * 1 <= 100000 && !visit[now.num *1]) { // *2 연상를 수행해서 만들 수 있는 인접 행렬 
    			q.add(new Point(now.num*1, now.cnt +1));
    			visit[now.num*1] = true;
    		}
    		
    		
    	}
    	return -1;
    	
    	
    	
    	
    	
    	
    	
    }
    
    static class Point{
    	int num, cnt; // 정점, 정점이 만들어지기 위해 사용도니 연산된 수 

		public Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
    	
    }
}

